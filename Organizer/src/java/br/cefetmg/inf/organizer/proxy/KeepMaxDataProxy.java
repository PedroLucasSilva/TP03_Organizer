/*
 * @author Ruan Bertuce
 */

package br.cefetmg.inf.organizer.proxy;

import br.cefetmg.inf.organizer.dist.ClientDistribution;
import br.cefetmg.inf.organizer.model.domain.Item;
import br.cefetmg.inf.organizer.model.domain.MaxDataObject;
import br.cefetmg.inf.organizer.model.domain.Tag;
import br.cefetmg.inf.organizer.model.domain.User;
import br.cefetmg.inf.organizer.model.service.IKeepMaxData;
import br.cefetmg.inf.util.PseudoPackage;
import br.cefetmg.inf.util.RequestType;
import br.cefetmg.inf.util.exception.PersistenceException;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeepMaxDataProxy implements IKeepMaxData {
    
    private ClientDistribution client;

    public KeepMaxDataProxy() throws SocketException, UnknownHostException {
        client = ClientDistribution.getInstance();
    }

    @Override
    public boolean updateAllItems(MaxDataObject maxDataObject) throws PersistenceException {
        PseudoPackage contentPackage;
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(maxDataObject));
        
        RequestType requestType = RequestType.UPDATEALLITEMS;
        contentPackage = new PseudoPackage(requestType, jsonContent);
        try {
            PseudoPackage receivedPackage = client.request(contentPackage);
          
            return Boolean.valueOf(receivedPackage.getContent().get(0));
            
        } catch (IOException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateAllTags(MaxDataObject maxDataObject) throws PersistenceException {
        PseudoPackage contentPackage;
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(maxDataObject));
        
        RequestType requestType = RequestType.UPDATEALLTAGS;
        contentPackage = new PseudoPackage(requestType, jsonContent);
        try {
            PseudoPackage receivedPackage = client.request(contentPackage);
          
            return Boolean.valueOf(receivedPackage.getContent().get(0));
            
        } catch (IOException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean updateAllItemTag(MaxDataObject maxDataObject) throws PersistenceException {
        PseudoPackage contentPackage;
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(maxDataObject));
        
        RequestType requestType = RequestType.UPDATEALLITEMTAG;
        contentPackage = new PseudoPackage(requestType, jsonContent);
        try {
            PseudoPackage receivedPackage = client.request(contentPackage);
          
            return Boolean.valueOf(receivedPackage.getContent().get(0));
            
        } catch (IOException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public ArrayList<Item> loadItems(User user) throws PersistenceException {
        PseudoPackage contentPackage;
        JsonReader reader;
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(user));
        
        RequestType requestType = RequestType.LOADITEMS;
        contentPackage = new PseudoPackage(requestType, jsonContent);
        
        try {
            PseudoPackage receivedPackage = client.request(contentPackage);
            
            reader = new JsonReader(new StringReader(receivedPackage.getContent().get(0)));
            reader.setLenient(true);
           
            return json.fromJson(receivedPackage.getContent().get(0), ArrayList.class);
            
        } catch (IOException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ArrayList<Tag> loadTags(User user) throws PersistenceException {
        PseudoPackage contentPackage;
        JsonReader reader;
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(user));
        
        RequestType requestType = RequestType.LOADTAGS;
        contentPackage = new PseudoPackage(requestType, jsonContent);
        
        try {
            PseudoPackage receivedPackage = client.request(contentPackage);
            
            reader = new JsonReader(new StringReader(receivedPackage.getContent().get(0)));
            reader.setLenient(true);
           
            return json.fromJson(receivedPackage.getContent().get(0), ArrayList.class);
            
        } catch (IOException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ArrayList<String> loadTagsItems(User user) throws PersistenceException {
        PseudoPackage contentPackage;
        JsonReader reader;
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(user));
        
        RequestType requestType = RequestType.LOADTAGSITEMS;
        contentPackage = new PseudoPackage(requestType, jsonContent);
        
        try {
            PseudoPackage receivedPackage = client.request(contentPackage);
            
            reader = new JsonReader(new StringReader(receivedPackage.getContent().get(0)));
            reader.setLenient(true);
           
            return json.fromJson(receivedPackage.getContent().get(0), ArrayList.class);
            
        } catch (IOException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public ArrayList<String> loadItemsTags(User user) throws PersistenceException {
        PseudoPackage contentPackage;
        JsonReader reader;
        Gson json = new Gson();
        
        List<String> jsonContent;
        jsonContent = new ArrayList();
        jsonContent.add(json.toJson(user));
        
        RequestType requestType = RequestType.LOADITEMSTAGS;
        contentPackage = new PseudoPackage(requestType, jsonContent);
        
        try {
            PseudoPackage receivedPackage = client.request(contentPackage);
            
            reader = new JsonReader(new StringReader(receivedPackage.getContent().get(0)));
            reader.setLenient(true);
           
            return json.fromJson(receivedPackage.getContent().get(0), ArrayList.class);
            
        } catch (IOException ex) {
            Logger.getLogger(KeepUserProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
