package user_service_api.router;

public interface UserServiceRouter {

    String ROOT = "/user";

    String CREATE = ROOT + "/creating";

    String MIGRATE_ROLE = ROOT + "/role/migrate";

    String EMAIL = ROOT + "/email";

    interface ID {
        String ROOT = UserServiceRouter.ROOT + PathVariables.ID;

        String PASSWORD = ROOT + "/password";
        String STATUS = ROOT + "/status";
        String LANGUAGE = ROOT + "/language";
        String ROLE = ROOT + "/role";
        String TIMEZONE = ROOT + "/timezone";
    }

    interface PathVariables {
        String ID = "/{id}";
    }
}
