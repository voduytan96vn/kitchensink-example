package org.jboss.as.quickstarts.kitchensink.controller;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.as.quickstarts.kitchensink.model.Member;

@Stateful
@Model
public class MemberService {

	@Inject
	private Logger log;

	@Inject
	private FacesContext facesContext;

	@Inject
	private EntityManager em;

	@Inject
	private Event<Member> memberEventSrc;

	private Member newMember;

	@Produces
	@Named
	public Member getNewMember() {
		return newMember;
	}

	public void register() throws Exception {
		log.info("Registering " + newMember.getName());
		em.persist(newMember);
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Đăng ký thành công!", "Registration successful"));
		memberEventSrc.fire(newMember);
		initNewMember();
	}

	@PostConstruct
	public void initNewMember() {
		newMember = new Member();
	}

	public void delete(Member member) {
		Query query = em.createQuery("delete FROM Member m where m.id='" + member.getId() + "'");

		query.executeUpdate();
		memberEventSrc.fire(member);

	}
}
