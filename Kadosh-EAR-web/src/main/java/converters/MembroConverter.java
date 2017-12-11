package converters;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import org.itbparnamirim.kadosh.data.MembroDAO;
import org.itbparnamirim.kadosh.model.Membro;

@Named
@SessionScoped
@FacesConverter(value = "membroConverter")
public class MembroConverter implements Converter, Serializable{

    @Inject MembroDAO membroDAO;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (membroDAO == null){
            System.out.println("MEMBRO DAO NULO");
        }
        Object object = membroDAO.encontrar(Long.parseLong(value));
        return object;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Membro membro = (Membro) value;
        return String.valueOf(membro.getId());
    }
}
