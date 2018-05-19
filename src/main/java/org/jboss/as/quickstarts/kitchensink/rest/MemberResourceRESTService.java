package org.jboss.as.quickstarts.kitchensink.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.as.quickstarts.kitchensink.model.Member;

@Path("/members")
@RequestScoped
public class MemberResourceRESTService {
	@Inject
	private EntityManager em;

	@GET
	@Produces("text/xml")
	public List<Member> listAllMembers() {
		@SuppressWarnings("unchecked")
		final List<Member> results = em.createQuery("select m from Member m order by m.name").getResultList();
		return results;
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces("text/xml")
	public Member lookupMemberById(@PathParam("id") long id) {
		return em.find(Member.class, id);
	}
}
