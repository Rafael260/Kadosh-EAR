package org.itbparnamirim.kadosh6.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import org.itbparnamirim.kadosh.ejb.MeditacaoBean;
import org.itbparnamirim.kadosh.ejb.MeditacaoBeanLocal;
import org.itbparnamirim.kadosh.model.Meditacao;
import org.itbparnamirim.kadosh.model.Membro;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

@ManagedBean(name = "meditacaoWizardMB")
@ViewScoped
public class MeditacaoWizardMB implements Serializable {

    private Meditacao meditacao;
    private String versiculoTentativa;
    private boolean skip;
    @EJB
    MeditacaoBeanLocal meditacaoBean;

    public Meditacao getMeditacao() {
        return meditacao;
    }

    public void setMeditacao(Meditacao meditacao) {
        this.meditacao = meditacao;
    }

    public String getVersiculoTentativa() {
        return versiculoTentativa;
    }

    public void setVersiculoTentativa(String versiculoTentativa) {
        this.versiculoTentativa = versiculoTentativa;
    }

    public void carregarMeditacao() {
        Meditacao med;
        HttpSession session = ManagedBeanUtil.getSession();
        med = (Meditacao) session.getAttribute("meditacao");
        this.meditacao = med;
        meditacaoBean.iniciarMeditacao(meditacao, (Membro) session.getAttribute("membroLogado"));
    }

    public void save() {
        System.out.println("SALVANDO, AGORA DEVE MOSTRAR A MENSAGEM");
        FacesMessage message = new FacesMessage(FacesMessage.FACES_MESSAGES, "Parabéns por concluir a meditação!");
        message.setSummary("Parabéns!");
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        String oldStep = event.getOldStep();
        String newStep = event.getNewStep();
//        System.out.println("Passo atual: "+ oldStep);
//        System.out.println("Passo novo: "+ newStep);
        if (oldStep.equals("decorando") && newStep.equals("aprofundando")) {
            boolean acertouVersiculo = meditacaoBean.acertouVersiculo(versiculoTentativa);
            if (!acertouVersiculo) {
                FacesMessage message = new FacesMessage(FacesMessage.FACES_MESSAGES, "O versículo não é esse.");
                message.setSummary("Errou");
                RequestContext.getCurrentInstance().showMessageInDialog(message);
                return oldStep;
            }
            FacesMessage message = new FacesMessage(FacesMessage.FACES_MESSAGES, "Parabéns, é esse versículo!");
            message.setSummary("Acertou!");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
        }

        return newStep;
    }
}
