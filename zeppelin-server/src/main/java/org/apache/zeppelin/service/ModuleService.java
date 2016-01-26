package org.apache.zeppelin.service;

import com.google.gson.Gson;
import org.apache.zeppelin.modules.ModuleData;
import org.apache.zeppelin.modules.ModuleProxy;
import org.apache.zeppelin.server.JsonResponse;
import org.apache.zeppelin.service.common.DFUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by zhanglei on 2016/1/20.
 */

@Path("/module")
@Produces("application/json")
public class ModuleService {
    Logger logger = LoggerFactory.getLogger(ModuleService.class);

    Gson gson = new Gson();

    public ModuleService() {
    }

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

    @GET
    @Path("/execute")
    public Response executeModule(@Context UriInfo info) {
        Map<String, String> params = new HashMap<>();
        MultivaluedMap<String, String> queryParams = info.getQueryParameters();

        for (String key : queryParams.keySet()) {
            params.put(key, queryParams.getFirst(key));
        }

        ModuleData data = new ModuleData(DFUtils.getPrevId(), DFUtils.createDFId());
        String type = "input", name = "FileInput";
        ModuleProxy.executeModule(type, name, data, params);

        return Response.ok().build();
    }
}

