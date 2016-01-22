package org.apache.zeppelin.service;

import org.apache.zeppelin.modules.ModuleProxy;
import org.apache.zeppelin.server.JsonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by zhanglei on 2016/1/20.
 */

@Path("/module")
@Produces("application/json")
public class ModuleService {
    Logger logger = LoggerFactory.getLogger(ModuleService.class);

    public ModuleService() {}

//    @GET
//    @Path("/")
//    public Response getAllTypes() {
//        return new JsonResponse(Response.Status.OK, "", ModuleProxy.getTypeNames()).build();
//    }

    @GET
    @Path("/")
    public Response getAllModules() {
        return new JsonResponse(Response.Status.OK, "", ModuleProxy.getTypeModules()).build();
    }

    @GET
    @Path("{type}")
    public Response getModuleParams(@PathParam("type") String type, @MatrixParam("name") String name) {
        return new JsonResponse(Response.Status.OK, "", ModuleProxy.getModuleParams(type, name)).build();
    }
}

