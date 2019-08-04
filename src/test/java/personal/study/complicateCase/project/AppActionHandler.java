package personal.study.complicateCase.project;

import org.junit.jupiter.api.Test;

public class AppActionHandler {

    @Test
    public void tryCallingThisComplicateThing() {

        ActionHandler actionHandler = new ActionHandler(new Service() {
            @Override
            public void doAction(String request, Callback<Response> callback) {
                System.out.println("========================Myself begin==========================");

                System.out.println(request);
                Response response = new Response();
                response.setData(new Data("Data is here"));
                response.setIsValid(true);
                callback.reply(response);

                System.out.println("========================Myself end==========================");
            }
        });

        actionHandler.doAction();

    }

}
