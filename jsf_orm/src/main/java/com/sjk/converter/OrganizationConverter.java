package com.sjk.converter;

import com.sjk.model.Organization;
import com.sjk.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Sebastian on 2015-06-20.
 */
@FacesConverter(forClass = Organization.class)
public class OrganizationConverter implements Converter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object valueToRender){
        Organization org = (Organization) valueToRender;
        return org.toString();
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue){
        Pattern idPattern = Pattern.compile("id=\\d");
        Matcher matcher = idPattern.matcher(submittedValue);
        if(matcher.find()){
            idPattern = Pattern.compile("\\d");
            matcher = idPattern.matcher(matcher.group());
            if(matcher.find()) {
                String idString = matcher.group();
                long id = Long.parseLong(idString);
                Session session = HibernateUtils.getSessionFactory().openSession();
                Query queryOrganizationById = session.getNamedQuery("Organization.findById");
                queryOrganizationById.setParameter("id", id);
                List<Organization> orgs = queryOrganizationById.list();
                if(orgs!=null && orgs.size()>0){
                    Organization org = orgs.get(0);
                    System.out.println("Find Org "+ org);
                    return org;
                }
            }

        }
        System.out.println("Submitted value: "+ submittedValue);
        return null;
    }

}
