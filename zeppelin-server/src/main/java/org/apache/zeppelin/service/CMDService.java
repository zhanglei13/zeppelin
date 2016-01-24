package org.apache.zeppelin.service;

/**
 * Created by zhanglei on 2016/1/13.
 */

import org.apache.zeppelin.interpreter.InterpreterResult;
import org.apache.zeppelin.server.JsonResponse;
import org.apache.zeppelin.service.common.CMDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/cmd")
@Produces("application/json")
public class CMDService {
    Logger logger = LoggerFactory.getLogger(CMDService.class);

    public CMDService() {
    }

    @GET
    @Path("execute/{cmd}")
    public Response excuteCMD(@PathParam("cmd") String cmd) throws IOException {
        if (cmd == null || cmd.equals("")) return Response.noContent().build();
        cmd = "%sql select * from df";
        return new JsonResponse(Response.Status.OK, "", CMDUtils.execute(cmd).message()).build();
    }

    @GET
    public Response getRoot() {
        return Response.ok().build();
    }
}
