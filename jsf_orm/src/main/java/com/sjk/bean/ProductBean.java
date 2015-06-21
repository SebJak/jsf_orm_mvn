package com.sjk.bean;

import com.sjk.model.Organization;
import com.sjk.model.Product;
import com.sjk.services.OrganizationService;
import com.sjk.services.ProductService;
import org.primefaces.event.CellEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Sebastian on 2015-06-16.
 */
@ManagedBean
@ViewScoped
public class ProductBean implements Serializable {

	private Product product;
	private ProductService productService;
	private OrganizationService organizationService;
	private List<Product> list;
	private List<Organization> suppliers;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void create(){
		if (validateDate() && checkProductCode()) {
			productService.create(product);
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Success", "Product has been added to the system.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		else{
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Date not validates", "The expiration date can not be before today.");
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

    }

	private boolean checkProductCode(){
		Product productByCode = productService.getProductByCode(product.getCode());
		if(productByCode!=null){
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"The code exists.", "The product with this code exists: "+productByCode.toString());
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return false;
		}
		return true;
	}

	public boolean validateDate(){
		Date current = new Date();
		return !product.getExpirationDate().before(current);
	}

	public ProductBean() {
		organizationService = new OrganizationService();
		product = new Product();
		productService = new ProductService();
		suppliers = organizationService.getSupplierOrganizations();
	}

	public List<Organization> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Organization> suppliers) {
		this.suppliers = suppliers;
	}

	public java.util.List<Product> getList() {
		if (list == null)
			list = productService.getAllProducts();
		return this.list;
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Cell Changed", "Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
			int itemIndex = event.getRowIndex();
			Product product = list.get(itemIndex);
			productService.update(product);
		}
	}

	public void deleteAction(Product pro) {
		list.remove(pro);
		productService.delete(pro);
	}
	//
}
