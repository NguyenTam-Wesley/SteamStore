/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.steamdata.exception.NoSuchGameException;
import com.liferay.steamdata.model.Game;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the game service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GameUtil
 * @generated
 */
@ProviderType
public interface GamePersistence extends BasePersistence<Game> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GameUtil} to access the game persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the game in the entity cache if it is enabled.
	 *
	 * @param game the game
	 */
	public void cacheResult(Game game);

	/**
	 * Caches the games in the entity cache if it is enabled.
	 *
	 * @param games the games
	 */
	public void cacheResult(java.util.List<Game> games);

	/**
	 * Creates a new game with the primary key. Does not add the game to the database.
	 *
	 * @param appId the primary key for the new game
	 * @return the new game
	 */
	public Game create(long appId);

	/**
	 * Removes the game with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appId the primary key of the game
	 * @return the game that was removed
	 * @throws NoSuchGameException if a game with the primary key could not be found
	 */
	public Game remove(long appId) throws NoSuchGameException;

	public Game updateImpl(Game game);

	/**
	 * Returns the game with the primary key or throws a <code>NoSuchGameException</code> if it could not be found.
	 *
	 * @param appId the primary key of the game
	 * @return the game
	 * @throws NoSuchGameException if a game with the primary key could not be found
	 */
	public Game findByPrimaryKey(long appId) throws NoSuchGameException;

	/**
	 * Returns the game with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appId the primary key of the game
	 * @return the game, or <code>null</code> if a game with the primary key could not be found
	 */
	public Game fetchByPrimaryKey(long appId);

	/**
	 * Returns all the games.
	 *
	 * @return the games
	 */
	public java.util.List<Game> findAll();

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
	public java.util.List<Game> findAll(int start, int end);

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
	public java.util.List<Game> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Game>
			orderByComparator);

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
	public java.util.List<Game> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Game>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the games from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of games.
	 *
	 * @return the number of games
	 */
	public int countAll();

}