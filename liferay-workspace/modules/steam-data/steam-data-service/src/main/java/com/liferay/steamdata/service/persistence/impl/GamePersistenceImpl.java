/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.steamdata.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.steamdata.exception.NoSuchGameException;
import com.liferay.steamdata.model.Game;
import com.liferay.steamdata.model.GameTable;
import com.liferay.steamdata.model.impl.GameImpl;
import com.liferay.steamdata.model.impl.GameModelImpl;
import com.liferay.steamdata.service.persistence.GamePersistence;
import com.liferay.steamdata.service.persistence.GameUtil;
import com.liferay.steamdata.service.persistence.impl.constants.LiferayPersistenceConstants;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the game service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = GamePersistence.class)
public class GamePersistenceImpl
	extends BasePersistenceImpl<Game> implements GamePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GameUtil</code> to access the game persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GameImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public GamePersistenceImpl() {
		setModelClass(Game.class);

		setModelImplClass(GameImpl.class);
		setModelPKClass(long.class);

		setTable(GameTable.INSTANCE);
	}

	/**
	 * Caches the game in the entity cache if it is enabled.
	 *
	 * @param game the game
	 */
	@Override
	public void cacheResult(Game game) {
		entityCache.putResult(GameImpl.class, game.getPrimaryKey(), game);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the games in the entity cache if it is enabled.
	 *
	 * @param games the games
	 */
	@Override
	public void cacheResult(List<Game> games) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (games.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Game game : games) {
			if (entityCache.getResult(GameImpl.class, game.getPrimaryKey()) ==
					null) {

				cacheResult(game);
			}
		}
	}

	/**
	 * Clears the cache for all games.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GameImpl.class);

		finderCache.clearCache(GameImpl.class);
	}

	/**
	 * Clears the cache for the game.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Game game) {
		entityCache.removeResult(GameImpl.class, game);
	}

	@Override
	public void clearCache(List<Game> games) {
		for (Game game : games) {
			entityCache.removeResult(GameImpl.class, game);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(GameImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(GameImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new game with the primary key. Does not add the game to the database.
	 *
	 * @param appId the primary key for the new game
	 * @return the new game
	 */
	@Override
	public Game create(long appId) {
		Game game = new GameImpl();

		game.setNew(true);
		game.setPrimaryKey(appId);

		return game;
	}

	/**
	 * Removes the game with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appId the primary key of the game
	 * @return the game that was removed
	 * @throws NoSuchGameException if a game with the primary key could not be found
	 */
	@Override
	public Game remove(long appId) throws NoSuchGameException {
		return remove((Serializable)appId);
	}

	/**
	 * Removes the game with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the game
	 * @return the game that was removed
	 * @throws NoSuchGameException if a game with the primary key could not be found
	 */
	@Override
	public Game remove(Serializable primaryKey) throws NoSuchGameException {
		Session session = null;

		try {
			session = openSession();

			Game game = (Game)session.get(GameImpl.class, primaryKey);

			if (game == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGameException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(game);
		}
		catch (NoSuchGameException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Game removeImpl(Game game) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(game)) {
				game = (Game)session.get(
					GameImpl.class, game.getPrimaryKeyObj());
			}

			if (game != null) {
				session.delete(game);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (game != null) {
			clearCache(game);
		}

		return game;
	}

	@Override
	public Game updateImpl(Game game) {
		boolean isNew = game.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(game);
			}
			else {
				game = (Game)session.merge(game);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(GameImpl.class, game, false, true);

		if (isNew) {
			game.setNew(false);
		}

		game.resetOriginalValues();

		return game;
	}

	/**
	 * Returns the game with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the game
	 * @return the game
	 * @throws NoSuchGameException if a game with the primary key could not be found
	 */
	@Override
	public Game findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGameException {

		Game game = fetchByPrimaryKey(primaryKey);

		if (game == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGameException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return game;
	}

	/**
	 * Returns the game with the primary key or throws a <code>NoSuchGameException</code> if it could not be found.
	 *
	 * @param appId the primary key of the game
	 * @return the game
	 * @throws NoSuchGameException if a game with the primary key could not be found
	 */
	@Override
	public Game findByPrimaryKey(long appId) throws NoSuchGameException {
		return findByPrimaryKey((Serializable)appId);
	}

	/**
	 * Returns the game with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appId the primary key of the game
	 * @return the game, or <code>null</code> if a game with the primary key could not be found
	 */
	@Override
	public Game fetchByPrimaryKey(long appId) {
		return fetchByPrimaryKey((Serializable)appId);
	}

	/**
	 * Returns all the games.
	 *
	 * @return the games
	 */
	@Override
	public List<Game> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Game> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Game> findAll(
		int start, int end, OrderByComparator<Game> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Game> findAll(
		int start, int end, OrderByComparator<Game> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Game> list = null;

		if (useFinderCache) {
			list = (List<Game>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GAME);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GAME;

				sql = sql.concat(GameModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Game>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the games from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Game game : findAll()) {
			remove(game);
		}
	}

	/**
	 * Returns the number of games.
	 *
	 * @return the number of games
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GAME);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "appId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GAME;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GameModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the game persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		GameUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		GameUtil.setPersistence(null);

		entityCache.removeCache(GameImpl.class.getName());
	}

	@Override
	@Reference(
		target = LiferayPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = LiferayPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = LiferayPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_GAME = "SELECT game FROM Game game";

	private static final String _SQL_COUNT_GAME =
		"SELECT COUNT(game) FROM Game game";

	private static final String _ORDER_BY_ENTITY_ALIAS = "game.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Game exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		GamePersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}