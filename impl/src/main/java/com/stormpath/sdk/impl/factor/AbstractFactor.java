/*
 * Copyright 2013 Stormpath, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stormpath.sdk.impl.factor;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.factor.Factor;
import com.stormpath.sdk.factor.FactorStatus;
import com.stormpath.sdk.factor.FactorType;
import com.stormpath.sdk.factor.sms.FactorVerificationStatus;
import com.stormpath.sdk.impl.ds.InternalDataStore;
import com.stormpath.sdk.impl.resource.*;

import java.util.Date;
import java.util.Map;

/**
 * @since 1.0.4
 */
public class AbstractFactor extends AbstractInstanceResource implements Factor {
    static final StatusProperty<FactorType> FACTOR_TYPE = new StatusProperty<>("type", FactorType.class);
    static final ResourceReference<Account> ACCOUNT = new ResourceReference<>("account", Account.class);
    public static final StatusProperty<FactorStatus> STATUS = new StatusProperty<>("status", FactorStatus.class);
    public static final StatusProperty<FactorVerificationStatus> VERIFICATION_STATUS = new StatusProperty<>("verificationStatus", FactorVerificationStatus.class);
    public static final DateProperty CREATED_AT = new DateProperty("createdAt");
    public static final DateProperty MODIFIED_AT = new DateProperty("modifiedAt");

    static final Map<String, Property> PROPERTY_DESCRIPTORS = createPropertyDescriptorMap(FACTOR_TYPE, ACCOUNT, STATUS, VERIFICATION_STATUS, CREATED_AT, MODIFIED_AT);

    public AbstractFactor(InternalDataStore dataStore) {
        super(dataStore);
    }

    public AbstractFactor(InternalDataStore dataStore, Map<String, Object> properties) {
        super(dataStore, properties);
    }

    @Override
    public Map<String, Property> getPropertyDescriptors() {
        return PROPERTY_DESCRIPTORS;
    }

    @Override
    public FactorStatus getStatus() {
        String value = getStringProperty(STATUS.getName());
        if (value == null) {
            return null;
        }
        return FactorStatus.valueOf(value.toUpperCase());
    }

    @Override
    public Factor setStatus(FactorStatus status) {
        setProperty(STATUS, status.name());
        return this;
    }

    @Override
    public FactorVerificationStatus getFactorVerificationStatus() {
        String value = getStringProperty(VERIFICATION_STATUS.getName());
        if (value == null) {
            return null;
        }
        return FactorVerificationStatus.valueOf(value.toUpperCase());
    }

    @Override
    public Factor setFactorVerificationStatus(FactorVerificationStatus verificationStatus) {
        setProperty(VERIFICATION_STATUS, verificationStatus.name());
        return this;
    }

    @Override
    public FactorType getFactorType() {
        String value = getStringProperty(FACTOR_TYPE.getName());
        if (value == null) {
            return null;
        }
        return FactorType.valueOf(value.toUpperCase());
    }

    @Override
    public Factor setFactorType(FactorType factorType) {
        setProperty(FACTOR_TYPE, factorType.name());
        return this;
    }

    @Override
    public Account getAccount() {
        return getResourceProperty(ACCOUNT);
    }

    @Override
    public Factor setAccount(Account account) {
        setResourceProperty(ACCOUNT,account);
        return this;
    }

    @Override
    public void delete() {
        getDataStore().delete(this);
    }

    @Override
    public Date getCreatedAt() {
        return getDateProperty(CREATED_AT);
    }

    @Override
    public Date getModifiedAt() {
        return getDateProperty(MODIFIED_AT);
    }
}