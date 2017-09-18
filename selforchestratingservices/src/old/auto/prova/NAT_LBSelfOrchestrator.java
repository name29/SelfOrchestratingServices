package it.polito.netgroup.selforchestratingservices.auto.prova;

import java.util.ArrayList;
import java.util.HashMap;

import it.polito.netgroup.nffg.json.*;
import it.polito.netgroup.selforchestratingservices.*;
import it.polito.netgroup.selforchestratingservices.declarative.*;


//Autogenerated method
public class NAT_LBSelfOrchestrator extends AbstractSelfOrchestrator
{
	Variables variables = new VariablesImplementation();
	NatElementaryService natelementaryservice;
	public NAT_LBSelfOrchestrator(Infrastructure _infrastructure)
	{
		TimeoutMap<String,HostNat> active_hosts = new TimeoutMap<>();
		variables.setVar("active_hosts", TimeoutMap.class);
		
		ArrayList<Host> hosts = new ArrayList<>();
		variables.setVar("hosts", ArrayList.class);
		
		String lbport = new String("SWITCH_LAN:Port0:1");
		variables.setVar("lbport", String.class);
		
		String lbmac = new String("02:01:02:03:04:05");
		variables.setVar("lbmac", String.class);
		

		natelementaryservice  = new NatElementaryService(variables);
		HashMap<String,ElementaryService> elementaryServices = new HashMap<>();
		elementaryServices.put(natelementaryservice.getName(),natelementaryservice);
		init("NAT_LB",elementaryServices,_infrastructure);
	}
}