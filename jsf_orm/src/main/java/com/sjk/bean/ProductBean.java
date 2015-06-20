package com.sjk.bean;

import com.sjk.model.Product;
import com.sjk.services.ProductService;
import org.primefaces.event.CellEditEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**
 * Created by Sebastian on 2015-06-16.
 */
@ManagedBean
@SessionScoped
public class ProductBean {

	private Product product = new Product();
	private ProductService ProductService = new ProductService();
	public List<Product> list;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void create(){
        //TODO complete this method
    }
    
	public java.util.List<Product> getList() {
		if (list == null)
			list = ProductService.getAllProducts();
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
			Product product = list.get(itemIndex);
			ProductService.update(product);
		}
	}

	public void deleteAction(Product pro) {
		list.remove(pro);
		ProductService.delete(pro);
	}
	//
}
