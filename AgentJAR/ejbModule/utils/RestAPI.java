package utils;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.acl.ACLMessage;
import model.agent.AID;
import model.agent.AgentType;
import model.center.AgentCenter;

public interface RestAPI {
	
	@GET
	@Path("/agents/classes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AgentType> getAgentTypes();
	
	@POST
	@Path("/agents/classes")
	@Consumes(MediaType.APPLICATION_JSON)
	public void newAgentTypes(List<AgentType> newTypes);
	
	@GET
	@Path("/agents/running")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AID> getRunningAgents();
	
	@POST
	@Path("/agents/running")
	@Produces(MediaType.APPLICATION_JSON)
	public void addRunningAgents(List<AID> runningAgents);
	
	@PUT
	@Path("/agents/running/{type}/{name}")
	public void startAgent(@PathParam("type") String type,@PathParam("name") String name);
	
	@DELETE
	@Path("/agents/running/{aid}")
	public void stopAgent(@PathParam("aid") String aid);
	
	@POST
	@Path("/messages")
	@Consumes(MediaType.APPLICATION_JSON)
	public void sendMessage(ACLMessage msg);

	@GET
	@Path("/messages")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getPerformatives();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/node")
	public void connectNodes(AgentCenter request);
	
	@DELETE
	@Path("/node/{alias}")
	public void deleteNode(@PathParam("alias") String alias);
	
	@GET
	@Path("/node")
	public String heartBeat();
	
}