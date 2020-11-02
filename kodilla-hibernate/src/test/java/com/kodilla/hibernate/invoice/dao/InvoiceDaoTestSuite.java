package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave(){
        //Given
        Product water = new Product("Water");
        Product cola = new Product("Coca cola");
        Product sprite = new Product("Sprite");

        Item item1 = new Item( new BigDecimal(2), 4, new BigDecimal(8));
        item1.setProduct(water);

        Item item2 = new Item( new BigDecimal(4), 3, new BigDecimal(12));
        item2.setProduct(cola);

        Item item3 = new Item( new BigDecimal(5), 1, new BigDecimal(5));
        item3.setProduct(sprite);


        Invoice invoice1 = new Invoice("FV-1-2020");
        invoice1.getItems().add(item1);
        invoice1.getItems().add(item2);

        Invoice invoice2 = new Invoice("FV-2-2020");
        invoice2.getItems().add(item1);

        Invoice invoice3 = new Invoice("FV-3-2020");
        invoice3.getItems().add(item3);
        invoice3.getItems().add(item1);

        item1.setInvoice(invoice1);
        item1.setInvoice(invoice2);

        item2.setInvoice(invoice1);

        item3.setInvoice(invoice3);
        item1.setInvoice(invoice3);

        //When
        invoiceDao.save(invoice1);
        int invoice1Id = invoice1.getId();

        invoiceDao.save(invoice2);
        int invoice2Id = invoice2.getId();

        invoiceDao.save(invoice3);
        int invoice3Id = invoice3.getId();

        //Then
        Assert.assertNotEquals(0, invoice1Id);
        Assert.assertNotEquals(0, invoice2Id);
        Assert.assertNotEquals(0, invoice3Id);

        //CleanUp
        try{
            invoiceDao.deleteById(invoice1Id);
            invoiceDao.deleteById(invoice2Id);
            invoiceDao.deleteById(invoice3Id);
        } catch (Exception e){
            //do nothing
        }
    }
}