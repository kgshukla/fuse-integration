package com.redhat.consulting.fusequickstarts.eap.deployment.route;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public interface SourceData {

	@GET
	@Path(value="/{type}/{ip}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public String getXMLData(@PathParam("type") String type, @PathParam("ip") String ip);
	
}
