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

//Autogenerated file
public class NatInfrastructureResourceResourceTemplate implements ResourceTemplate
{
	public NatInfrastructureResourceResourceTemplate()
	{
	}

	@Override
	public List<DeclarativeFlowRule> getDefaultFlowRules() {
		List<DeclarativeFlowRule> default_flowrules = new ArrayList<DeclarativeFlowRule>();
		
		DeclarativeFlowRule dfr0 = new DeclarativeFlowRuleImpl();
		dfr0.linkPorts("WAN_SWITCH_WAN:port","WAN","SWITCH_WAN:port");
		default_flowrules.add(dfr0);
		DeclarativeFlowRule dfr1 = new DeclarativeFlowRuleImpl();
		dfr1.linkPorts("management_SWITCH_MAN:port","management","SWITCH_MAN:port");
		default_flowrules.add(dfr1);
		return default_flowrules;
	}

	@Override
	public ConfigurationSDN getDefaultConfiguration() {
		NatConfiguration default_cfg = new NatConfiguration(null, null, null,null);
		try
			{
				default_cfg.setIP(new InterfaceLabel("User"), new IpAddressAndNetmask("192.168.10.1", "255.255.255.0") , new MacAddress("02:01:02:03:04:05"));
		}catch(InvalidInterfaceLabel e)
		{
			e.printStackTrace();
			return null;
		}
		return default_cfg;
	}
	@Override
	public Class<? extends Resource> getType()
	{
		return NatInfrastructureResource.class;
	}

	@Override
	public void init(Variables var, Resource resource, Framework framework) throws Exception
	{
		if ( ! (resource instanceof NatInfrastructureResource))
		{
			throw new InvalidParameterException("Resource is not 'NatInfrastructureResource'");
		}
		NatInfrastructureResource r = (NatInfrastructureResource) resource;
		framework.addDirtyChecker(new ListDirtyChecker<NatInfrastructureResource,NatSession>("nat_session_state",r,
					new DirtyExecute<List<NatSession>>() {
						@Override
						public List<NatSession> execute() throws Exception {
							return r.getNatSession();
						}
					},"100ms", new DirtyCheckerEventHandler<NatInfrastructureResource,NatSession>()
		{
		
			@Override
			public boolean on_new(NatInfrastructureResource object, NatSession value) throws Exception
			{
				return On_new_nat_sessionEventHandler.fire(var,object,value);
			}
			public boolean on_del(NatInfrastructureResource object, NatSession value) throws Exception
			{
				return On_del_nat_sessionEventHandler.fire(var,object,value);
			}
			@Override
			public boolean on_change(NatInfrastructureResource object, NatSession old, NatSession now) throws Exception
			{
				return false;
			}
		}));
		
	}}