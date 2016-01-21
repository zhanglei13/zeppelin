package org.apache.zeppelin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by zhanglei on 2016/1/20.
 */

@Path("/module")
@Produces("application/json")
public class ModuleService {
    Logger logger = LoggerFactory.getLogger(ModuleService.class);

    public ModuleService() {}

    @GET
    public Response getRoot() {
        return Response.ok().build();
    }
}

