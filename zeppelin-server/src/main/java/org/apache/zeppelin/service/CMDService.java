package org.apache.zeppelin.service;

/**
 * Created by zhanglei on 2016/1/13.
 */

import org.apache.zeppelin.service.common.CMDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.io.IOException;

/**
 * Interpreter Rest API
 *
 */
@Path("/cmd")
@Produces("application/json")
public class CMDService {
    Logger logger = LoggerFactory.getLogger(CMDService.class);

    public CMDService() {}

    @GET
    @Path("cmd/execute/{cmd}")
    public String excuteCMD(@PathParam("cmd") String cmd) throws IOException{
        return CMDUtils.execute(cmd).message();
    }
}
