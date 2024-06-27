/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.steamdata.model.Game;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the game service. This utility wraps <code>com.liferay.steamdata.service.persistence.impl.GamePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GamePersistence
 * @generated
 */
public class GameUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Game game) {
		getPersistence().clearCache(game);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Game> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Game> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Game> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Game> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Game> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Game update(Game game) {
		return getPersistence().update(game);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Game update(Game game, ServiceContext serviceContext) {
		return getPersistence().update(game, serviceContext);
	}

	/**
	 * Caches the game in the entity cache if it is enabled.
	 *
	 * @param game the game
	 */
	public static void cacheResult(Game game) {
		getPersistence().cacheResult(game);
	}

	/**
	 * Caches the games in the entity cache if it is enabled.
	 *
	 * @param games the games
	 */
	public static void cacheResult(List<Game> games) {
		getPersistence().cacheResult(games);
	}

	/**
	 * Creates a new game with the primary key. Does not add the game to the database.
	 *
	 * @param appId the primary key for the new game
	 * @return the new game
	 */
	public static Game create(long appId) {
		return getPersistence().create(appId);
	}

	/**
	 * Removes the game with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appId the primary key of the game
	 * @return the game that was removed
	 * @throws NoSuchGameException if a game with the primary key could not be found
	 */
	public static Game remove(long appId)
		throws com.liferay.steamdata.exception.NoSuchGameException {

		return getPersistence().remove(appId);
	}

	public static Game updateImpl(Game game) {
		return getPersistence().updateImpl(game);
	}

	/**
	 * Returns the game with the primary key or throws a <code>NoSuchGameException</code> if it could not be found.
	 *
	 * @param appId the primary key of the game
	 * @return the game
	 * @throws NoSuchGameException if a game with the primary key could not be found
	 */
	public static Game findByPrimaryKey(long appId)
		throws com.liferay.steamdata.exception.NoSuchGameException {

		return getPersistence().findByPrimaryKey(appId);
	}

	/**
	 * Returns the game with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appId the primary key of the game
	 * @return the game, or <code>null</code> if a game with the primary key could not be found
	 */
	public static Game fetchByPrimaryKey(long appId) {
		return getPersistence().fetchByPrimaryKey(appId);
	}

	/**
	 * Returns all the games.
	 *
	 * @return the games
	 */
	public static List<Game> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the games.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of games
	 * @param end the upper bound of the range of games (not inclusive)
	 * @return the range of games
	 */
	public static List<Game> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the games.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of games
	 * @param end the upper bound of the range of games (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of games
	 */
	public static List<Game> findAll(
		int start, int end, OrderByComparator<Game> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the games.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GameModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of games
	 * @param end the upper bound of the range of games (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of games
	 */
	public static List<Game> findAll(
		int start, int end, OrderByComparator<Game> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the games from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of games.
	 *
	 * @return the number of games
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static GamePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(GamePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile GamePersistence _persistence;

}