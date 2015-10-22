package org.Serveur;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface RdvDao {
	@SqlUpdate("create table rdv (idt integer primary key autoincrement, idClient integer, idBarber integer, date varchar(20), heure varchar(20))")
	public void createRdvTable();

	@SqlUpdate("insert into rdv (idClient, idBarber, date,  heure) values (:idClient, :idBarber, :date,  :heure)")
	@GetGeneratedKeys
	public int insert(@BindBean Rdv r);

	@SqlUpdate("update rdv set idClient = :idClient, idBarber = :idBarber, date = :date, heure = :heure")
	public void update(@BindBean Rdv r);
	
	@SqlQuery("select count(*) from rdv")
	public int count();
	
	@SqlQuery("select * from rdv where idt = :idt")
    @RegisterMapperFactory(BeanMapperFactory.class)
	public Rdv findByIdt(@Bind("idt") int idt);
	
	@SqlQuery("select * from rdv where idBarber = :idBarber order by date, heure")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public List<Rdv> listerRdvByBarber(@Bind("idBarber") int idBarber);
	
	@SqlQuery("select * from rdv where idClient = :idClient order by date, heure")
	@RegisterMapperFactory(BeanMapperFactory.class)
	public List<Rdv> listerRdvByClient(@Bind("idClient") int idClient);
	
	@SqlUpdate("delete from rdv where idt = :idt")
	public int deleteClient(@Bind("idt") int idt);

	@SqlUpdate("drop table if exists rdv")
	public void dropRdvTable();

	public void close();
}