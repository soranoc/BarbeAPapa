package org.Serveur;



import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlBatch;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface CPDao {
	
	@SqlUpdate("create table CP (cp text, ville text)")
	void createCpTable();
	
	@SqlQuery("select * from cp where cp = :name")
    @RegisterMapperFactory(BeanMapperFactory.class)
	List<Ville> findByName(@Bind("name") String name);
	
	@SqlQuery("select * from cp order by cp")
	@RegisterMapperFactory(BeanMapperFactory.class)
	List<Ville> all();
	
	@SqlUpdate("drop table if exists CP")
	void dropCpTable();
	
	@SqlBatch("insert into CP (cp, ville) values (:cp, :ville)")
	void load(@Bind("cp") List<String> cp, @Bind("ville") List<String> ville);
	
	
}
