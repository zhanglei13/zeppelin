package org.apache.zeppelin.service.common;

import org.apache.zeppelin.interpreter.InterpreterResult;
import org.apache.zeppelin.notebook.Note;
import org.apache.zeppelin.notebook.Paragraph;
import org.apache.zeppelin.scheduler.Job;
import org.apache.zeppelin.server.ZeppelinServer;

import java.io.IOException;

/**
 * Created by zhanglei on 2016/1/13.
 */
public class CMDUtils {

    public static InterpreterResult execute(String cmd) {
        Note note = null;
        try {
            note = ZeppelinServer.notebook.createNote();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        Paragraph p = note.addParagraph();
        p.setText(cmd);
        note.run(p.getId());
        waitForFinish(p);
        InterpreterResult result = p.getResult();
        ZeppelinServer.notebook.removeNote(note.id());
        return result;
    }

    private static void waitForFinish(Paragraph p) {
        while (p.getStatus() != Job.Status.FINISHED) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
