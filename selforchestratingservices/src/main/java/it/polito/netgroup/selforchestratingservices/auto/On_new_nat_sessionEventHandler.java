package it.polito.netgroup.selforchestratingservices.auto;

import java.security.*;
import java.util.*;
import java.util.stream.*;
import it.polito.netgroup.configurationorchestrator.*;
import it.polito.netgroup.configurationorchestrator.json.nat.*;
import it.polito.netgroup.selforchestratingservices.*;
import it.polito.netgroup.nffg.json.*;
import it.polito.netgroup.selforchestratingservices.declarative_new.*;
import it.polito.netgroup.selforchestratingservices.declarative.*;
import it.polito.netgroup.selforchestratingservices.declarative.infrastructureresources.*;
import it.polito.netgroup.selforchestratingservices.declarative.dirtychecker.*;

public class On_new_nat_sessionEventHandler 
{
	public static boolean fire(Variables var,NatInfrastructureResource nat, NatSession session) throws Exception
	{
		TimeoutMap<String,HostNat> active_hosts = null;
		try
		{
			active_hosts = var.getVar("active_hosts",TimeoutMap.class);
		}catch(Exception e){
			e.printStackTrace();
		}

		ArrayList<Host> hosts = null;
		try
		{
			hosts = var.getVar("hosts",ArrayList.class);
		}catch(Exception e){
			e.printStackTrace();
		}

		String lbport = null;
		try
		{
			lbport = var.getVar("lbport",String.class);
		}catch(Exception e){
			e.printStackTrace();
		}

		String lbmac = null;
		try
		{
			lbmac = var.getVar("lbmac",String.class);
		}catch(Exception e){
			e.printStackTrace();
		}

		Integer counter = null;
		try
		{
			counter = var.getVar("counter",Integer.class);
		}catch(Exception e){
			e.printStackTrace();
		}

		Host session_host = ( new Host(session.getSrc_address(),(nat.getArpTable().stream().filter(x -> x.getIp_address().equals(session.getSrc_address())).collect(Collectors.toCollection(ArrayList::new)) ).get(0).getMac_address()) );
		active_hosts.put(session.getSrc_address(), ( new HostNat(session_host,nat) ));

		return true;
	}

}