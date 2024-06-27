/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Publisher}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Publisher
 * @generated
 */
public class PublisherWrapper
	extends BaseModelWrapper<Publisher>
	implements ModelWrapper<Publisher>, Publisher {

	public PublisherWrapper(Publisher publisher) {
		super(publisher);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("publisherId", getPublisherId());
		attributes.put("publisherName", getPublisherName());
		attributes.put("linkWebsite", getLinkWebsite());
		attributes.put("publisherInfo", getPublisherInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String publisherId = (String)attributes.get("publisherId");

		if (publisherId != null) {
			setPublisherId(publisherId);
		}

		String publisherName = (String)attributes.get("publisherName");

		if (publisherName != null) {
			setPublisherName(publisherName);
		}

		String linkWebsite = (String)attributes.get("linkWebsite");

		if (linkWebsite != null) {
			setLinkWebsite(linkWebsite);
		}

		String publisherInfo = (String)attributes.get("publisherInfo");

		if (publisherInfo != null) {
			setPublisherInfo(publisherInfo);
		}
	}

	@Override
	public Publisher cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the link website of this publisher.
	 *
	 * @return the link website of this publisher
	 */
	@Override
	public String getLinkWebsite() {
		return model.getLinkWebsite();
	}

	/**
	 * Returns the primary key of this publisher.
	 *
	 * @return the primary key of this publisher
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publisher ID of this publisher.
	 *
	 * @return the publisher ID of this publisher
	 */
	@Override
	public String getPublisherId() {
		return model.getPublisherId();
	}

	/**
	 * Returns the publisher info of this publisher.
	 *
	 * @return the publisher info of this publisher
	 */
	@Override
	public String getPublisherInfo() {
		return model.getPublisherInfo();
	}

	/**
	 * Returns the publisher name of this publisher.
	 *
	 * @return the publisher name of this publisher
	 */
	@Override
	public String getPublisherName() {
		return model.getPublisherName();
	}

	/**
	 * Returns the uuid of this publisher.
	 *
	 * @return the uuid of this publisher
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the link website of this publisher.
	 *
	 * @param linkWebsite the link website of this publisher
	 */
	@Override
	public void setLinkWebsite(String linkWebsite) {
		model.setLinkWebsite(linkWebsite);
	}

	/**
	 * Sets the primary key of this publisher.
	 *
	 * @param primaryKey the primary key of this publisher
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publisher ID of this publisher.
	 *
	 * @param publisherId the publisher ID of this publisher
	 */
	@Override
	public void setPublisherId(String publisherId) {
		model.setPublisherId(publisherId);
	}

	/**
	 * Sets the publisher info of this publisher.
	 *
	 * @param publisherInfo the publisher info of this publisher
	 */
	@Override
	public void setPublisherInfo(String publisherInfo) {
		model.setPublisherInfo(publisherInfo);
	}

	/**
	 * Sets the publisher name of this publisher.
	 *
	 * @param publisherName the publisher name of this publisher
	 */
	@Override
	public void setPublisherName(String publisherName) {
		model.setPublisherName(publisherName);
	}

	/**
	 * Sets the uuid of this publisher.
	 *
	 * @param uuid the uuid of this publisher
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected PublisherWrapper wrap(Publisher publisher) {
		return new PublisherWrapper(publisher);
	}

}