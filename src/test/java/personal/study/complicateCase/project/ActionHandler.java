package personal.study.complicateCase.project;

public class ActionHandler {

    private Service service;

    public ActionHandler(Service service) {
        this.service = service;
    }

    public void doAction() {
        service.doAction("our-request", new Callback<Response>() {
            @Override
            public void reply(Response response) {
                handleResponse(response);
            }
        });
    }

    private void handleResponse(Response response) {
        System.out.println("===============ActionHandler.handleResponse begin ===================");
        if (response.isValid()) {
            response.setData(new Data("Successful data response"));
        }
        System.out.println("===============ActionHandler.handleResponse end ===================");
    }

}
