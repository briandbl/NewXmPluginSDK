package com.xiaomi.smarthome.device.api.spec.operation.controller;

import android.content.Context;

import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.ActionParam;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;

import java.util.List;

public class ServiceController extends SpecService {
    public ServiceController(int iid, String type, String description, List<PropertyController> properties,
                             List<ActionController> actions) {
        super(iid, type, description);
        for (PropertyController controller : properties) {
            this.getProperties().put(controller.getIid(), controller);
        }

        for (ActionController controller : actions) {
            this.getActions().put(controller.getIid(), controller);
        }
    }

    public void updateValue(PropertyParam operation) {
        PropertyController controller = (PropertyController) getProperties().get(operation.getPiid());
        if (controller != null) {
            controller.updateValue(operation);
        }
    }

    public void setSpecProperty(Context context, final PropertyParam operation) {
        PropertyController controller = (PropertyController) getProperties().get(operation.getPiid());
        if (controller != null) {
            controller.setSpecProperty(context, operation);
        }
    }

    public void doAction(Context context, final ActionParam operation) {
        ActionController controller = (ActionController) getActions().get(operation.getAiid());
        if (controller != null) {
            controller.doAction(context, operation);
        }
    }
}
