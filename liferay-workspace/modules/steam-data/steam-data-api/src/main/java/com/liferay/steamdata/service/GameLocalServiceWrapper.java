/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link GameLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GameLocalService
 * @generated
 */
public class GameLocalServiceWrapper
	implements GameLocalService, ServiceWrapper<GameLocalService> {

	public GameLocalServiceWrapper() {
		this(null);
	}

	public GameLocalServiceWrapper(GameLocalService gameLocalService) {
		_gameLocalService = gameLocalService;
	}

	/**
	 * Adds the game to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param game the game
	 * @return the game that was added
	 */
	@Override
	public com.liferay.steamdata.model.Game addGame(
		com.liferay.steamdata.model.Game game) {

		return _gameLocalService.addGame(game);
	}

	/**
	 * Creates a new game with the primary key. Does not add the game to the database.
	 *
	 * @param appId the primary key for the new game
	 * @return the new game
	 */
	@Override
	public com.liferay.steamdata.model.Game createGame(long appId) {
		return _gameLocalService.createGame(appId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gameLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the game from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param game the game
	 * @return the game that was removed
	 */
	@Override
	public com.liferay.steamdata.model.Game deleteGame(
		com.liferay.steamdata.model.Game game) {

		return _gameLocalService.deleteGame(game);
	}

	/**
	 * Deletes the game with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appId the primary key of the game
	 * @return the game that was removed
	 * @throws PortalException if a game with the primary key could not be found
	 */
	@Override
	public com.liferay.steamdata.model.Game deleteGame(long appId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gameLocalService.deleteGame(appId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gameLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _gameLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _gameLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _gameLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _gameLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.steamdata.model.impl.GameModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _gameLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.steamdata.model.impl.GameModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _gameLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _gameLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _gameLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.steamdata.model.Game fetchGame(long appId) {
		return _gameLocalService.fetchGame(appId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _gameLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the game with the primary key.
	 *
	 * @param appId the primary key of the game
	 * @return the game
	 * @throws PortalException if a game with the primary key could not be found
	 */
	@Override
	public com.liferay.steamdata.model.Game getGame(long appId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gameLocalService.getGame(appId);
	}

	/**
	 * Returns a range of all the games.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.steamdata.model.impl.GameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of games
	 * @param end the upper bound of the range of games (not inclusive)
	 * @return the range of games
	 */
	@Override
	public java.util.List<com.liferay.steamdata.model.Game> getGames(
		int start, int end) {

		return _gameLocalService.getGames(start, end);
	}

	/**
	 * Returns the number of games.
	 *
	 * @return the number of games
	 */
	@Override
	public int getGamesCount() {
		return _gameLocalService.getGamesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _gameLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _gameLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _gameLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the game in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GameLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param game the game
	 * @return the game that was updated
	 */
	@Override
	public com.liferay.steamdata.model.Game updateGame(
		com.liferay.steamdata.model.Game game) {

		return _gameLocalService.updateGame(game);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _gameLocalService.getBasePersistence();
	}

	@Override
	public GameLocalService getWrappedService() {
		return _gameLocalService;
	}

	@Override
	public void setWrappedService(GameLocalService gameLocalService) {
		_gameLocalService = gameLocalService;
	}

	private GameLocalService _gameLocalService;

}