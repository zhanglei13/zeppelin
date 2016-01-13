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

    public static InterpreterResult execute(String cmd) throws IOException {
        // create new note
        Note note = ZeppelinServer.notebook.createNote();

        // run markdown paragraph, again
        Paragraph p = note.addParagraph();
        p.setText(cmd);
        note.run(p.getId());
        waitForFinish(p);
        ZeppelinServer.notebook.removeNote(note.id());
        return p.getResult();
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
