package pl.allegro.braincode.messages.category;

import java.util.HashMap;
import java.util.Map;

public enum CategoryDto {
    CARS {
        @Override
        public Map<String, String> getProperties() {
            Map<String,String> props = new HashMap<>();
            props.put(CATEGORY,"Samochody osobowe");
            props.put("używane","tak");
            props.put("rok produkcji","od 1990");
            props.put("rodzaj paliwa","benzyna");
            props.put("nadwozie","Sedan/Limuzyna");
            props.put("nadwozie","Sedan/Limuzyna");
            props.put("uszkodzony","nie");
            props.put("wyposażenie - pozostałe","alufelgi");
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
