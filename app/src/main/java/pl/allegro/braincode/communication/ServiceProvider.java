package pl.allegro.braincode.communication;

import lombok.Getter;

@Getter
public enum ServiceProvider {
    INSTANCE;

    private ServerService serverService;

    ServiceProvider() {
        serverService = ServiceCreator.createServerService();
    }
}
