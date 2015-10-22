package org.Serveur;

import java.util.List;

import org.Serveur.Barber;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface BarberDao {
	@SqlUpdate("create table barbers (idt integer primary key autoincrement, photo varchar(255), nom varchar(100), prenom varchar(100), entreprise varchar(100), site varchar(100), adresse varchar(100), codePostal varchar(5),ville varchar(100), mail varchar(100), mdp varchar(40), dateNaiss varchar(20), tel varchar(20), fax varchar(20),   description varchar(500), facebook varchar(100), twitter varchar(100), linkedIn varchar(100), googlePlus varchar(100), typeDePrestation varchar(100), valide boolean)")
	public void createBarberTable();

	@SqlUpdate("insert into barbers (photo, nom, prenom, entreprise, site, adresse, codePostal, ville, mail, mdp, dateNaiss, tel, fax, description, facebook, twitter, linkedIn, googlePlus, typeDePrestation, valide) values (:photo, :nom, :prenom, :entreprise, :site,  :adresse, :codePostal, :ville, :mail, :mdp, :dateNaiss, :tel, :fax, :description, :facebook, :twitter, :linkedIn, :googlePlus, :typeDePrestation, :valide)")
	@GetGeneratedKeys
	public int insert(@BindBean Barber c);

	@SqlUpdate("update barbers set photo = :photo, nom = :nom, prenom = :prenom, entreprise = :entreprise,  site=:site, adresse = :adresse, codePostal = :codePostal, ville = :ville, mail = :mail, mdp = :mdp, dateNaiss = :dateNaiss, tel = :tel, fax = :fax, metier = :metier, domaineAct = :domaineAct, description = :description, facebook = :facebook, twitter = :twitter, linkedIn = :linkedIn, googlePlus = :googlePlus, typeDePrestation = :typeDePrestation where idt = :idt")
	public void update(@BindBean Barber c);
	
	@SqlQuery("select count(*) from barbers")
	public int count();
	
	@SqlQuery("select * from barbers where idt = :idt")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Barber findByIdt(@Bind("idt") int idt);
	
	@SqlQuery("select * from barbers where mail = :mail and mdp = :mdp")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Barber logIn(@Bind("mail") String mail, @Bind("mdp") String mdp);
	
	@SqlQuery("select * from barbers order by ville, nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public List<Barber> listerBarbers();
	
	@SqlQuery("select * from barbers where nom = :nom order by ville, nom")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public List<Barber> searchByName(@Bind("nom") String nom);
	
	@SqlQuery("select * from barbers where mail = :mail")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public Barber getByMail(@Bind("mail") String mail);
	
	@SqlUpdate("update barbers set valide = :valide where idt= :idt")
	public int validerBarber(@Bind("idt") int idt, @Bind("valide") boolean valide);
	
	@SqlUpdate("delete from barbers where idt = :idt")
	public int deleteBarber(@Bind("idt") int idt);

	@SqlUpdate("drop table if exists barbers")
	public void dropBarberTable();

	public void close();
}
