package ru.stqa.pft.mantis.appmanager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Request;
import ru.stqa.pft.mantis.model.Issue;
import ru.stqa.pft.mantis.tests.TestBase;

import java.io.IOException;
import java.util.Set;

public class RestHelper extends TestBase {

    private ApplicationManager app;

    public RestHelper(ApplicationManager app) {
        this.app = app;
    }

    private org.apache.http.client.fluent.Executor getExecutor() {
        return org.apache.http.client.fluent.Executor.newInstance().auth("28accbe43ea112d9feb328d2c00b3eed", "");
    }

    public Issue getIssue (int issueId) throws IOException {
        String issueIdStr= Integer.toString(issueId);
        String json = getExecutor()

                .execute(Request.Get("http://demo.bugify.com/api/issues/"+Integer.toString(issueId)+".json"))
                .returnContent().asString();
        JsonElement parsed = new JsonParser().parse(json);

        JsonElement issue = parsed.getAsJsonObject().get("issues");

        Set<Issue> issues = new Gson().fromJson(issue, new TypeToken<Set<Issue>>(){}.getType());
        if(issues.iterator().hasNext()){
            Issue issueData = issues.iterator().next();
            return issueData;
        }
        else{
            return null;
        }



    }



}
