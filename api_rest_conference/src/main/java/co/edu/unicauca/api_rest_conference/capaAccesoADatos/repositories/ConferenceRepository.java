package co.edu.unicauca.api_rest_conference.capaAccesoADatos.repositories;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
//import java.util.Arrays;
import org.springframework.stereotype.Repository;

import co.edu.unicauca.api_rest_conference.capaAccesoADatos.models.ConferenceEntity;

@Repository
public class ConferenceRepository {
    private ArrayList<ConferenceEntity> listConferences; //Aqui se almacenaran las conferencias
    private AtomicInteger idIterator;
    public ConferenceRepository(){
        this.listConferences = new ArrayList<ConferenceEntity>();
        //loadConferences();
        idIterator = new AtomicInteger(listConferences.size());

    }
    public ArrayList<ConferenceEntity> findAll(){ //Recupera todas las conferencias guardadas
        System.out.println("Getting all the conferences");
        return this.listConferences;
    }
    public ConferenceEntity findById(Integer id){
        System.out.println("Looking for a conference");
        ConferenceEntity conference = null;
        for(ConferenceEntity conf : listConferences){
            if(conf.getId().equals(id)){
                conference = conf;
                break;
            }
        }
        if(conference==null){
            System.out.println("Conference not found");
        }
        return conference;
    }
    public ConferenceEntity save(ConferenceEntity conf){
        System.out.println("Saving a conference");
        conf.setId(idIterator.incrementAndGet());
        ConferenceEntity conference = null;
        if(listConferences.add(conf)){
            conference = conf;
        }
        return conference;

    }
    public ConferenceEntity update(Integer id, ConferenceEntity newConference){
        System.out.println("Updating a conference");
        ConferenceEntity oldConference = findById(id);
        if(oldConference!=null){
            newConference.setId(solveId(id,newConference.getId()));
            int index = findIndex(id);
            listConferences.set(index, newConference);
            return newConference;
        }
        return null;
    }

    public int countArticlesInConference(Integer id){
        System.out.println("Counting articles in a conference");
        ConferenceEntity conference = findById(id);
        return conference.getArticles().size();
    }

    //Este metodo encuentra el indice de la conferencia en la lista, puesto que el id no necesariamente
    //es el indice.
    private int findIndex(Integer id) {
        for(int i = 0; i < listConferences.size();i++){
            if(listConferences.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

    private Integer solveId(Integer id, Integer newId){
        if(id.equals(newId)){
            return id;
        }
        for(ConferenceEntity conf : listConferences){
            if(conf.getId().equals(newId)){
                return solveId(id,newId+1);
            }
        }
        return newId;
    }

    public boolean addArticleToConference(Integer idConference, Integer idArticle){
        System.out.println("Adding an article to a conference");
        ConferenceEntity conference = findById(idConference);
        if(conference!=null){
            List<Integer> articles = new ArrayList<Integer>(conference.getArticles());
            if(articles.contains(idArticle)){
                System.out.println("Article already in the conference");
                return false;
            }
            articles.add(idArticle);
            conference.setArticles(articles);
            return true;
        }
        return false;
    }
    
    /*
    private void loadConferences() {
        ConferenceEntity conference1 = new ConferenceEntity();
        conference1.setId(1);
        conference1.setName("Tech Innovations 2024");
        conference1.setStartDate(new Date());
        conference1.setEndDate(new Date());
        conference1.setRegistrationCost(250.50f);
        conference1.setLocation("San Francisco, USA");
        conference1.setTopics(Arrays.asList("AI", "Blockchain", "Cybersecurity"));
        conference1.setArticles(Arrays.asList(1001, 1002, 1003));
        ConferenceEntity conference2 = new ConferenceEntity();
        conference2.setId(2);
        conference2.setName("Global Healthcare Summit 2024");
        conference2.setStartDate(new Date());
        conference2.setEndDate(new Date());
        conference2.setRegistrationCost(300.00f);
        conference2.setLocation("London, UK");
        conference2.setTopics(Arrays.asList("Telemedicine", "Genomics", "Medical Devices"));
        conference2.setArticles(Arrays.asList(1002, 1003));
        ConferenceEntity conference3 = new ConferenceEntity();
        conference3.setId(3);
        conference3.setName("Sustainability and Energy 2024");
        conference3.setStartDate(new Date());
        conference3.setEndDate(new Date());
        conference3.setRegistrationCost(150.75f);
        conference3.setLocation("Tokyo, Japan");
        conference3.setTopics(Arrays.asList("Renewable Energy", "Environmental Policies", "Green Technology"));
        conference3.setArticles(Arrays.asList(1001,1003));
        listConferences.add(conference1);
        listConferences.add(conference2);
        listConferences.add(conference3);
    }
    */

    public boolean delete(Integer id) {
        System.out.println("Deleting a conference");
        boolean bandera=false;
        int index = findIndex(id);
        if(index != -1) {
            listConferences.remove(index);
            return true;
        }
        return bandera;
    }

    public boolean exists(int id) {
        System.out.println("Checking if a conference exists");
        ConferenceEntity conference = findById(id);
        return conference!=null;
    }
    
}
