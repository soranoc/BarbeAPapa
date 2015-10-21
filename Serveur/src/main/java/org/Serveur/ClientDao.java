package com.adopt.bdd;
import java.util.List;

import mainpack.Items.Client;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface ClientDao {
	@SqlUpdate("create table clients (idt integer primary key autoincrement, photo varchar(255), nom varchar(100), prenom varchar(100),  adresse varchar(100), codePostal varchar(5),ville varchar(100), mail varchar(100), mdp varchar(40), dateNaiss varchar(20), tel varchar(20))")
	public void createClientTable();

	@SqlUpdate("insert into clients (photo, nom, prenom,  adresse, codePostal, ville, mail, mdp, dateNaiss, tel) values (:photo, :nom, :prenom,  :adresse, :codePostal, :ville, :mail, :mdp, :dateNaiss, :tel)")
	@GetGeneratedKeys
	public int insert(@BindBean Client c);

	@SqlUpdate("update clients set photo = :photo, nom = :nom, prenom = :prenom, adresse = :adresse, codePostal = :codePostal, ville = :ville, mail = :mail, mdp = :mdp, dateNaiss = :dateNaiss, tel = :tel")
	public void update(@BindBean Client c);
	
	@SqlQuery("select count(*) from clients")
	public int count();
	
	@SqlQuery("select * from clients where idt = :idt")
    @RegisterMapperFactory(BeanMapperFactory.class)
	public Client findByIdt(@Bind("idt") int idt);
	
	@SqlQuery("select * from clients where mail = :mail and mdp = :mdp")
    @RegisterMapperFactory(BeanMapperFactory.class)
	public Client logIn(@Bind("mail") String mail, @Bind("mdp") String mdp);
	
	@SqlQuery("select * from clients order by ville, nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public List<Client> listerClients();
	
	@SqlQuery("select * from clients where nom = :nom order by ville, nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public List<Client> searchByName(@Bind("nom") String nom);
	
	@SqlUpdate("delete from clients where idt = :idt")
	public int deleteClient(@Bind("idt") int idt);

	@SqlUpdate("drop table if exists clients")
	public void dropClientTable();

	public void close();
}