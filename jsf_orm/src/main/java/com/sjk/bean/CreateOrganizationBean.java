package com.sjk.bean;

import com.sjk.model.Organization;
import com.sjk.model.embedded.OrganizationContext;
import com.sjk.services.OrganizationService;
import com.sjk.utils.HibernateUtils;
import org.hibernate.Session;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by Sebastian on 2015-06-16.
 */
@ManagedBean
@SessionScoped
public class CreateOrganizationBean {

    private Organization org;

    private OrganizationService orgService;

    public  CreateOrganizationBean(){
        org = new Organization();
        orgService = new OrganizationService();
    }
    public Organization getOrg() {
        return org;
    }

    public void setOrg(Organization org) {
        this.org = org;
    }

    public OrganizationContext[] getContexts(){
        return OrganizationContext.values();
    }

    public void create(){
        //TODO create organization
        FacesContext context = FacesContext.getCurrentInstance();
        if(orgService.create(org)) {
            context.addMessage(null, new FacesMessage("Successful", "New Organization has been created"));
            cleanForm();
        }
        else
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",  "Some errors occurs during create organization") );

    }

    private void cleanForm(){
        org = new Organization();
    }
}
