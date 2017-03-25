package pl.allegro.braincode.messages.category;

import java.util.HashMap;
import java.util.Map;

public enum CategoryDto {
    CARS {
        @Override
        public Map<String, String> getProperties() {
            Map<String,String> props = new HashMap<>();
            props.put(CATEGORY,"Samochody osobowe");
            return props;
        }
    },
    PHONES {
        @Override
        public Map<String, String> getProperties() {
            Map<String,String> props = new HashMap<>();
            props.put(CATEGORY,"Telefony");
            return props;
        }
    },
    BICYCLES {
        @Override
        public Map<String, String> getProperties() {
            Map<String,String> props = new HashMap<>();
            props.put(CATEGORY,"Rowery");
            return props;
        }
    },
    FURNITURE {
        @Override
        public Map<String, String> getProperties() {
            Map<String,String> props = new HashMap<>();
            props.put(CATEGORY,"Meble");
            return props;
        }
    };

    public static final String CATEGORY = "Kategoria";

    public abstract Map<String,String> getProperties();

}
