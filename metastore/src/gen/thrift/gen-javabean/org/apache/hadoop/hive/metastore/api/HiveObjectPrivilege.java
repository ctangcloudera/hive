/**
 * Autogenerated by Thrift Compiler (0.7.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package org.apache.hadoop.hive.metastore.api;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HiveObjectPrivilege implements org.apache.thrift.TBase<HiveObjectPrivilege, HiveObjectPrivilege._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("HiveObjectPrivilege");

  private static final org.apache.thrift.protocol.TField HIVE_OBJECT_FIELD_DESC = new org.apache.thrift.protocol.TField("hiveObject", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField PRINCIPAL_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("principalName", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField PRINCIPAL_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("principalType", org.apache.thrift.protocol.TType.I32, (short)3);
  private static final org.apache.thrift.protocol.TField GRANT_INFO_FIELD_DESC = new org.apache.thrift.protocol.TField("grantInfo", org.apache.thrift.protocol.TType.STRUCT, (short)4);

  private HiveObjectRef hiveObject; // required
  private String principalName; // required
  private PrincipalType principalType; // required
  private PrivilegeGrantInfo grantInfo; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    HIVE_OBJECT((short)1, "hiveObject"),
    PRINCIPAL_NAME((short)2, "principalName"),
    /**
     * 
     * @see PrincipalType
     */
    PRINCIPAL_TYPE((short)3, "principalType"),
    GRANT_INFO((short)4, "grantInfo");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // HIVE_OBJECT
          return HIVE_OBJECT;
        case 2: // PRINCIPAL_NAME
          return PRINCIPAL_NAME;
        case 3: // PRINCIPAL_TYPE
          return PRINCIPAL_TYPE;
        case 4: // GRANT_INFO
          return GRANT_INFO;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.HIVE_OBJECT, new org.apache.thrift.meta_data.FieldMetaData("hiveObject", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, HiveObjectRef.class)));
    tmpMap.put(_Fields.PRINCIPAL_NAME, new org.apache.thrift.meta_data.FieldMetaData("principalName", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PRINCIPAL_TYPE, new org.apache.thrift.meta_data.FieldMetaData("principalType", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, PrincipalType.class)));
    tmpMap.put(_Fields.GRANT_INFO, new org.apache.thrift.meta_data.FieldMetaData("grantInfo", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, PrivilegeGrantInfo.class)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(HiveObjectPrivilege.class, metaDataMap);
  }

  public HiveObjectPrivilege() {
  }

  public HiveObjectPrivilege(
    HiveObjectRef hiveObject,
    String principalName,
    PrincipalType principalType,
    PrivilegeGrantInfo grantInfo)
  {
    this();
    this.hiveObject = hiveObject;
    this.principalName = principalName;
    this.principalType = principalType;
    this.grantInfo = grantInfo;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public HiveObjectPrivilege(HiveObjectPrivilege other) {
    if (other.isSetHiveObject()) {
      this.hiveObject = new HiveObjectRef(other.hiveObject);
    }
    if (other.isSetPrincipalName()) {
      this.principalName = other.principalName;
    }
    if (other.isSetPrincipalType()) {
      this.principalType = other.principalType;
    }
    if (other.isSetGrantInfo()) {
      this.grantInfo = new PrivilegeGrantInfo(other.grantInfo);
    }
  }

  public HiveObjectPrivilege deepCopy() {
    return new HiveObjectPrivilege(this);
  }

  @Override
  public void clear() {
    this.hiveObject = null;
    this.principalName = null;
    this.principalType = null;
    this.grantInfo = null;
  }

  public HiveObjectRef getHiveObject() {
    return this.hiveObject;
  }

  public void setHiveObject(HiveObjectRef hiveObject) {
    this.hiveObject = hiveObject;
  }

  public void unsetHiveObject() {
    this.hiveObject = null;
  }

  /** Returns true if field hiveObject is set (has been assigned a value) and false otherwise */
  public boolean isSetHiveObject() {
    return this.hiveObject != null;
  }

  public void setHiveObjectIsSet(boolean value) {
    if (!value) {
      this.hiveObject = null;
    }
  }

  public String getPrincipalName() {
    return this.principalName;
  }

  public void setPrincipalName(String principalName) {
    this.principalName = principalName;
  }

  public void unsetPrincipalName() {
    this.principalName = null;
  }

  /** Returns true if field principalName is set (has been assigned a value) and false otherwise */
  public boolean isSetPrincipalName() {
    return this.principalName != null;
  }

  public void setPrincipalNameIsSet(boolean value) {
    if (!value) {
      this.principalName = null;
    }
  }

  /**
   * 
   * @see PrincipalType
   */
  public PrincipalType getPrincipalType() {
    return this.principalType;
  }

  /**
   * 
   * @see PrincipalType
   */
  public void setPrincipalType(PrincipalType principalType) {
    this.principalType = principalType;
  }

  public void unsetPrincipalType() {
    this.principalType = null;
  }

  /** Returns true if field principalType is set (has been assigned a value) and false otherwise */
  public boolean isSetPrincipalType() {
    return this.principalType != null;
  }

  public void setPrincipalTypeIsSet(boolean value) {
    if (!value) {
      this.principalType = null;
    }
  }

  public PrivilegeGrantInfo getGrantInfo() {
    return this.grantInfo;
  }

  public void setGrantInfo(PrivilegeGrantInfo grantInfo) {
    this.grantInfo = grantInfo;
  }

  public void unsetGrantInfo() {
    this.grantInfo = null;
  }

  /** Returns true if field grantInfo is set (has been assigned a value) and false otherwise */
  public boolean isSetGrantInfo() {
    return this.grantInfo != null;
  }

  public void setGrantInfoIsSet(boolean value) {
    if (!value) {
      this.grantInfo = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case HIVE_OBJECT:
      if (value == null) {
        unsetHiveObject();
      } else {
        setHiveObject((HiveObjectRef)value);
      }
      break;

    case PRINCIPAL_NAME:
      if (value == null) {
        unsetPrincipalName();
      } else {
        setPrincipalName((String)value);
      }
      break;

    case PRINCIPAL_TYPE:
      if (value == null) {
        unsetPrincipalType();
      } else {
        setPrincipalType((PrincipalType)value);
      }
      break;

    case GRANT_INFO:
      if (value == null) {
        unsetGrantInfo();
      } else {
        setGrantInfo((PrivilegeGrantInfo)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case HIVE_OBJECT:
      return getHiveObject();

    case PRINCIPAL_NAME:
      return getPrincipalName();

    case PRINCIPAL_TYPE:
      return getPrincipalType();

    case GRANT_INFO:
      return getGrantInfo();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case HIVE_OBJECT:
      return isSetHiveObject();
    case PRINCIPAL_NAME:
      return isSetPrincipalName();
    case PRINCIPAL_TYPE:
      return isSetPrincipalType();
    case GRANT_INFO:
      return isSetGrantInfo();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof HiveObjectPrivilege)
      return this.equals((HiveObjectPrivilege)that);
    return false;
  }

  public boolean equals(HiveObjectPrivilege that) {
    if (that == null)
      return false;

    boolean this_present_hiveObject = true && this.isSetHiveObject();
    boolean that_present_hiveObject = true && that.isSetHiveObject();
    if (this_present_hiveObject || that_present_hiveObject) {
      if (!(this_present_hiveObject && that_present_hiveObject))
        return false;
      if (!this.hiveObject.equals(that.hiveObject))
        return false;
    }

    boolean this_present_principalName = true && this.isSetPrincipalName();
    boolean that_present_principalName = true && that.isSetPrincipalName();
    if (this_present_principalName || that_present_principalName) {
      if (!(this_present_principalName && that_present_principalName))
        return false;
      if (!this.principalName.equals(that.principalName))
        return false;
    }

    boolean this_present_principalType = true && this.isSetPrincipalType();
    boolean that_present_principalType = true && that.isSetPrincipalType();
    if (this_present_principalType || that_present_principalType) {
      if (!(this_present_principalType && that_present_principalType))
        return false;
      if (!this.principalType.equals(that.principalType))
        return false;
    }

    boolean this_present_grantInfo = true && this.isSetGrantInfo();
    boolean that_present_grantInfo = true && that.isSetGrantInfo();
    if (this_present_grantInfo || that_present_grantInfo) {
      if (!(this_present_grantInfo && that_present_grantInfo))
        return false;
      if (!this.grantInfo.equals(that.grantInfo))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(HiveObjectPrivilege other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    HiveObjectPrivilege typedOther = (HiveObjectPrivilege)other;

    lastComparison = Boolean.valueOf(isSetHiveObject()).compareTo(typedOther.isSetHiveObject());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetHiveObject()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.hiveObject, typedOther.hiveObject);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPrincipalName()).compareTo(typedOther.isSetPrincipalName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrincipalName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.principalName, typedOther.principalName);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetPrincipalType()).compareTo(typedOther.isSetPrincipalType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrincipalType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.principalType, typedOther.principalType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetGrantInfo()).compareTo(typedOther.isSetGrantInfo());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetGrantInfo()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.grantInfo, typedOther.grantInfo);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    org.apache.thrift.protocol.TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == org.apache.thrift.protocol.TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // HIVE_OBJECT
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.hiveObject = new HiveObjectRef();
            this.hiveObject.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // PRINCIPAL_NAME
          if (field.type == org.apache.thrift.protocol.TType.STRING) {
            this.principalName = iprot.readString();
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 3: // PRINCIPAL_TYPE
          if (field.type == org.apache.thrift.protocol.TType.I32) {
            this.principalType = PrincipalType.findByValue(iprot.readI32());
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 4: // GRANT_INFO
          if (field.type == org.apache.thrift.protocol.TType.STRUCT) {
            this.grantInfo = new PrivilegeGrantInfo();
            this.grantInfo.read(iprot);
          } else { 
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          org.apache.thrift.protocol.TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();
    validate();
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.hiveObject != null) {
      oprot.writeFieldBegin(HIVE_OBJECT_FIELD_DESC);
      this.hiveObject.write(oprot);
      oprot.writeFieldEnd();
    }
    if (this.principalName != null) {
      oprot.writeFieldBegin(PRINCIPAL_NAME_FIELD_DESC);
      oprot.writeString(this.principalName);
      oprot.writeFieldEnd();
    }
    if (this.principalType != null) {
      oprot.writeFieldBegin(PRINCIPAL_TYPE_FIELD_DESC);
      oprot.writeI32(this.principalType.getValue());
      oprot.writeFieldEnd();
    }
    if (this.grantInfo != null) {
      oprot.writeFieldBegin(GRANT_INFO_FIELD_DESC);
      this.grantInfo.write(oprot);
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("HiveObjectPrivilege(");
    boolean first = true;

    sb.append("hiveObject:");
    if (this.hiveObject == null) {
      sb.append("null");
    } else {
      sb.append(this.hiveObject);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("principalName:");
    if (this.principalName == null) {
      sb.append("null");
    } else {
      sb.append(this.principalName);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("principalType:");
    if (this.principalType == null) {
      sb.append("null");
    } else {
      sb.append(this.principalType);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("grantInfo:");
    if (this.grantInfo == null) {
      sb.append("null");
    } else {
      sb.append(this.grantInfo);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

}

