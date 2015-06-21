package com.sjk.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sjk.model.Organization;
import com.sjk.model.Product;
import com.sjk.services.OrganizationService;
import com.sjk.services.UserService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;

/**
 * Created by Sebastian on 2015-06-16.
 */
@ManagedBean
@SessionScoped
public class OrgBean implements Serializable {

	private Organization organization = new Organization();
	private OrganizationService OrganizationService = new OrganizationService();
	public List<Organization> list;

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public java.util.List<Organization> getList() {
		if (list == null)
			list = OrganizationService.getAllOrganizations();
		return this.list;
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		System.out.println(oldValue);
		System.out.println(newValue);

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cell Changed", "Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			int itemIndex = event.getRowIndex();
			Organization organization = list.get(itemIndex);
			OrganizationService.update(organization);
		}
	}

	public void deleteAction(Organization org) {
		list.remove(org);
		OrganizationService.delete(org);
	}
	//
}
