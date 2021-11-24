package com.example.demo.client;




import java.util.List;


public interface ClientDAO {

    void insertClient(Client client);

    List<Client>  getAll();

    void saveClient(Client client);

    void updateClient(int id);

    void deleteClient(Client client);

    Client selectClient(int id);

}
