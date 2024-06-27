/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Game}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Game
 * @generated
 */
public class GameWrapper
	extends BaseModelWrapper<Game> implements Game, ModelWrapper<Game> {

	public GameWrapper(Game game) {
		super(game);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("appId", getAppId());
		attributes.put("publisherId", getPublisherId());
		attributes.put("title", getTitle());
		attributes.put("releaseDate", getReleaseDate());
		attributes.put("price", getPrice());
		attributes.put("aboutDescription", getAboutDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long appId = (Long)attributes.get("appId");

		if (appId != null) {
			setAppId(appId);
		}

		String publisherId = (String)attributes.get("publisherId");

		if (publisherId != null) {
			setPublisherId(publisherId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Date releaseDate = (Date)attributes.get("releaseDate");

		if (releaseDate != null) {
			setReleaseDate(releaseDate);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		String aboutDescription = (String)attributes.get("aboutDescription");

		if (aboutDescription != null) {
			setAboutDescription(aboutDescription);
		}
	}

	@Override
	public Game cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the about description of this game.
	 *
	 * @return the about description of this game
	 */
	@Override
	public String getAboutDescription() {
		return model.getAboutDescription();
	}

	/**
	 * Returns the app ID of this game.
	 *
	 * @return the app ID of this game
	 */
	@Override
	public long getAppId() {
		return model.getAppId();
	}

	/**
	 * Returns the price of this game.
	 *
	 * @return the price of this game
	 */
	@Override
	public double getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this game.
	 *
	 * @return the primary key of this game
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publisher ID of this game.
	 *
	 * @return the publisher ID of this game
	 */
	@Override
	public String getPublisherId() {
		return model.getPublisherId();
	}

	/**
	 * Returns the release date of this game.
	 *
	 * @return the release date of this game
	 */
	@Override
	public Date getReleaseDate() {
		return model.getReleaseDate();
	}

	/**
	 * Returns the title of this game.
	 *
	 * @return the title of this game
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the about description of this game.
	 *
	 * @param aboutDescription the about description of this game
	 */
	@Override
	public void setAboutDescription(String aboutDescription) {
		model.setAboutDescription(aboutDescription);
	}

	/**
	 * Sets the app ID of this game.
	 *
	 * @param appId the app ID of this game
	 */
	@Override
	public void setAppId(long appId) {
		model.setAppId(appId);
	}

	/**
	 * Sets the price of this game.
	 *
	 * @param price the price of this game
	 */
	@Override
	public void setPrice(double price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this game.
	 *
	 * @param primaryKey the primary key of this game
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publisher ID of this game.
	 *
	 * @param publisherId the publisher ID of this game
	 */
	@Override
	public void setPublisherId(String publisherId) {
		model.setPublisherId(publisherId);
	}

	/**
	 * Sets the release date of this game.
	 *
	 * @param releaseDate the release date of this game
	 */
	@Override
	public void setReleaseDate(Date releaseDate) {
		model.setReleaseDate(releaseDate);
	}

	/**
	 * Sets the title of this game.
	 *
	 * @param title the title of this game
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected GameWrapper wrap(Game game) {
		return new GameWrapper(game);
	}

}