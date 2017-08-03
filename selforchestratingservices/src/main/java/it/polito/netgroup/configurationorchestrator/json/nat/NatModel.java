
package it.polito.netgroup.configurationorchestrator.json.nat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * config-nat
 * <p>
 * Generated by pyang from module config-nat
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "config-nat:nat",
    "config-nat:floatingIP",
    "config-nat:interfaces"
})
public class NatModel {

    @JsonProperty("config-nat:nat")
    private ConfigNatNat configNatNat;
    @JsonProperty("config-nat:floatingIP")
    private List<FloatingIp> configNatFloatingIP = null;
    @JsonProperty("config-nat:interfaces")
    private ConfigNatInterfaces configNatInterfaces;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("config-nat:nat")
    public ConfigNatNat getConfigNatNat() {
        return configNatNat;
    }

    @JsonProperty("config-nat:nat")
    public void setConfigNatNat(ConfigNatNat configNatNat) {
        this.configNatNat = configNatNat;
    }

    @JsonProperty("config-nat:floatingIP")
    public List<FloatingIp> getConfigNatFloatingIP() {
        return configNatFloatingIP;
    }

    @JsonProperty("config-nat:floatingIP")
    public void setConfigNatFloatingIP(List<FloatingIp> configNatFloatingIP) {
        this.configNatFloatingIP = configNatFloatingIP;
    }

    @JsonProperty("config-nat:interfaces")
    public ConfigNatInterfaces getConfigNatInterfaces() {
        return configNatInterfaces;
    }

    @JsonProperty("config-nat:interfaces")
    public void setConfigNatInterfaces(ConfigNatInterfaces configNatInterfaces) {
        this.configNatInterfaces = configNatInterfaces;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
