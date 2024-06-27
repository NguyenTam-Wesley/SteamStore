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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.steamdata.exception.NoSuchPublisherException;
import com.liferay.steamdata.model.Publisher;
import com.liferay.steamdata.model.PublisherTable;
import com.liferay.steamdata.model.impl.PublisherImpl;
import com.liferay.steamdata.model.impl.PublisherModelImpl;
import com.liferay.steamdata.service.persistence.PublisherPersistence;
import com.liferay.steamdata.service.persistence.PublisherUtil;
import com.liferay.steamdata.service.persistence.impl.constants.LiferayPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the publisher service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PublisherPersistence.class)
public class PublisherPersistenceImpl
	extends BasePersistenceImpl<Publisher> implements PublisherPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PublisherUtil</code> to access the publisher persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PublisherImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the publishers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching publishers
	 */
	@Override
	public List<Publisher> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publishers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @return the range of matching publishers
	 */
	@Override
	public List<Publisher> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the publishers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching publishers
	 */
	@Override
	public List<Publisher> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Publisher> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the publishers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching publishers
	 */
	@Override
	public List<Publisher> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Publisher> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Publisher> list = null;

		if (useFinderCache) {
			list = (List<Publisher>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Publisher publisher : list) {
					if (!uuid.equals(publisher.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PUBLISHER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PublisherModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Publisher>)QueryUtil.list(
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
	 * Returns the first publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publisher
	 * @throws NoSuchPublisherException if a matching publisher could not be found
	 */
	@Override
	public Publisher findByUuid_First(
			String uuid, OrderByComparator<Publisher> orderByComparator)
		throws NoSuchPublisherException {

		Publisher publisher = fetchByUuid_First(uuid, orderByComparator);

		if (publisher != null) {
			return publisher;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPublisherException(sb.toString());
	}

	/**
	 * Returns the first publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching publisher, or <code>null</code> if a matching publisher could not be found
	 */
	@Override
	public Publisher fetchByUuid_First(
		String uuid, OrderByComparator<Publisher> orderByComparator) {

		List<Publisher> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publisher
	 * @throws NoSuchPublisherException if a matching publisher could not be found
	 */
	@Override
	public Publisher findByUuid_Last(
			String uuid, OrderByComparator<Publisher> orderByComparator)
		throws NoSuchPublisherException {

		Publisher publisher = fetchByUuid_Last(uuid, orderByComparator);

		if (publisher != null) {
			return publisher;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPublisherException(sb.toString());
	}

	/**
	 * Returns the last publisher in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching publisher, or <code>null</code> if a matching publisher could not be found
	 */
	@Override
	public Publisher fetchByUuid_Last(
		String uuid, OrderByComparator<Publisher> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Publisher> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the publishers before and after the current publisher in the ordered set where uuid = &#63;.
	 *
	 * @param publisherId the primary key of the current publisher
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next publisher
	 * @throws NoSuchPublisherException if a publisher with the primary key could not be found
	 */
	@Override
	public Publisher[] findByUuid_PrevAndNext(
			String publisherId, String uuid,
			OrderByComparator<Publisher> orderByComparator)
		throws NoSuchPublisherException {

		uuid = Objects.toString(uuid, "");

		Publisher publisher = findByPrimaryKey(publisherId);

		Session session = null;

		try {
			session = openSession();

			Publisher[] array = new PublisherImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, publisher, uuid, orderByComparator, true);

			array[1] = publisher;

			array[2] = getByUuid_PrevAndNext(
				session, publisher, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Publisher getByUuid_PrevAndNext(
		Session session, Publisher publisher, String uuid,
		OrderByComparator<Publisher> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PUBLISHER_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PublisherModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(publisher)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Publisher> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the publishers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Publisher publisher :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(publisher);
		}
	}

	/**
	 * Returns the number of publishers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching publishers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PUBLISHER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"publisher.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(publisher.uuid IS NULL OR publisher.uuid = '')";

	public PublisherPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Publisher.class);

		setModelImplClass(PublisherImpl.class);
		setModelPKClass(String.class);

		setTable(PublisherTable.INSTANCE);
	}

	/**
	 * Caches the publisher in the entity cache if it is enabled.
	 *
	 * @param publisher the publisher
	 */
	@Override
	public void cacheResult(Publisher publisher) {
		entityCache.putResult(
			PublisherImpl.class, publisher.getPrimaryKey(), publisher);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the publishers in the entity cache if it is enabled.
	 *
	 * @param publishers the publishers
	 */
	@Override
	public void cacheResult(List<Publisher> publishers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (publishers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Publisher publisher : publishers) {
			if (entityCache.getResult(
					PublisherImpl.class, publisher.getPrimaryKey()) == null) {

				cacheResult(publisher);
			}
		}
	}

	/**
	 * Clears the cache for all publishers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PublisherImpl.class);

		finderCache.clearCache(PublisherImpl.class);
	}

	/**
	 * Clears the cache for the publisher.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Publisher publisher) {
		entityCache.removeResult(PublisherImpl.class, publisher);
	}

	@Override
	public void clearCache(List<Publisher> publishers) {
		for (Publisher publisher : publishers) {
			entityCache.removeResult(PublisherImpl.class, publisher);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(PublisherImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(PublisherImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new publisher with the primary key. Does not add the publisher to the database.
	 *
	 * @param publisherId the primary key for the new publisher
	 * @return the new publisher
	 */
	@Override
	public Publisher create(String publisherId) {
		Publisher publisher = new PublisherImpl();

		publisher.setNew(true);
		publisher.setPrimaryKey(publisherId);

		String uuid = PortalUUIDUtil.generate();

		publisher.setUuid(uuid);

		return publisher;
	}

	/**
	 * Removes the publisher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher that was removed
	 * @throws NoSuchPublisherException if a publisher with the primary key could not be found
	 */
	@Override
	public Publisher remove(String publisherId)
		throws NoSuchPublisherException {

		return remove((Serializable)publisherId);
	}

	/**
	 * Removes the publisher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the publisher
	 * @return the publisher that was removed
	 * @throws NoSuchPublisherException if a publisher with the primary key could not be found
	 */
	@Override
	public Publisher remove(Serializable primaryKey)
		throws NoSuchPublisherException {

		Session session = null;

		try {
			session = openSession();

			Publisher publisher = (Publisher)session.get(
				PublisherImpl.class, primaryKey);

			if (publisher == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublisherException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(publisher);
		}
		catch (NoSuchPublisherException noSuchEntityException) {
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
	protected Publisher removeImpl(Publisher publisher) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publisher)) {
				publisher = (Publisher)session.get(
					PublisherImpl.class, publisher.getPrimaryKeyObj());
			}

			if (publisher != null) {
				session.delete(publisher);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (publisher != null) {
			clearCache(publisher);
		}

		return publisher;
	}

	@Override
	public Publisher updateImpl(Publisher publisher) {
		boolean isNew = publisher.isNew();

		if (!(publisher instanceof PublisherModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(publisher.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(publisher);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in publisher proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Publisher implementation " +
					publisher.getClass());
		}

		PublisherModelImpl publisherModelImpl = (PublisherModelImpl)publisher;

		if (Validator.isNull(publisher.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			publisher.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(publisher);
			}
			else {
				publisher = (Publisher)session.merge(publisher);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			PublisherImpl.class, publisherModelImpl, false, true);

		if (isNew) {
			publisher.setNew(false);
		}

		publisher.resetOriginalValues();

		return publisher;
	}

	/**
	 * Returns the publisher with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the publisher
	 * @return the publisher
	 * @throws NoSuchPublisherException if a publisher with the primary key could not be found
	 */
	@Override
	public Publisher findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublisherException {

		Publisher publisher = fetchByPrimaryKey(primaryKey);

		if (publisher == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublisherException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return publisher;
	}

	/**
	 * Returns the publisher with the primary key or throws a <code>NoSuchPublisherException</code> if it could not be found.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher
	 * @throws NoSuchPublisherException if a publisher with the primary key could not be found
	 */
	@Override
	public Publisher findByPrimaryKey(String publisherId)
		throws NoSuchPublisherException {

		return findByPrimaryKey((Serializable)publisherId);
	}

	/**
	 * Returns the publisher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher, or <code>null</code> if a publisher with the primary key could not be found
	 */
	@Override
	public Publisher fetchByPrimaryKey(String publisherId) {
		return fetchByPrimaryKey((Serializable)publisherId);
	}

	/**
	 * Returns all the publishers.
	 *
	 * @return the publishers
	 */
	@Override
	public List<Publisher> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publishers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @return the range of publishers
	 */
	@Override
	public List<Publisher> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the publishers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of publishers
	 */
	@Override
	public List<Publisher> findAll(
		int start, int end, OrderByComparator<Publisher> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the publishers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PublisherModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of publishers
	 */
	@Override
	public List<Publisher> findAll(
		int start, int end, OrderByComparator<Publisher> orderByComparator,
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

		List<Publisher> list = null;

		if (useFinderCache) {
			list = (List<Publisher>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PUBLISHER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLISHER;

				sql = sql.concat(PublisherModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Publisher>)QueryUtil.list(
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
	 * Removes all the publishers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Publisher publisher : findAll()) {
			remove(publisher);
		}
	}

	/**
	 * Returns the number of publishers.
	 *
	 * @return the number of publishers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PUBLISHER);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "publisherId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PUBLISHER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PublisherModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the publisher persistence.
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

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		PublisherUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		PublisherUtil.setPersistence(null);

		entityCache.removeCache(PublisherImpl.class.getName());
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

	private static final String _SQL_SELECT_PUBLISHER =
		"SELECT publisher FROM Publisher publisher";

	private static final String _SQL_SELECT_PUBLISHER_WHERE =
		"SELECT publisher FROM Publisher publisher WHERE ";

	private static final String _SQL_COUNT_PUBLISHER =
		"SELECT COUNT(publisher) FROM Publisher publisher";

	private static final String _SQL_COUNT_PUBLISHER_WHERE =
		"SELECT COUNT(publisher) FROM Publisher publisher WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "publisher.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Publisher exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Publisher exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PublisherPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}