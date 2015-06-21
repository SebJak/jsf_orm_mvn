package com.sjk.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sjk.model.Organization;
import com.sjk.model.Product;
import com.sjk.model.User;
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
public class UserBean implements Serializable {

	private User user = new User();
	private UserService UserService = new UserService();
	public List<User> list;

	public User getUser() {
		return user;
	}

	public java.util.List<User> getList() {
		if (list == null)
			list = UserService.getAllUsers();
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
			User user = list.get(itemIndex);
			UserService.updateUser(user);
		}
	}

	public void deleteAction(User user) {
		list.remove(user);
		UserService.deleteUser(user);
	}
	//
}
