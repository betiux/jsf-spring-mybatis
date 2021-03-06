/**
 *
 */
package com.jeetemplates.app.test.integration;

import com.jeetemplates.app.persistence.HelloWorldDao;
import java.io.FileInputStream;
import java.util.List;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jeetemplates.app.common.BaseDaoTest;
import com.jeetemplates.app.domain.HelloWorld;

/**
 * Test of {@link HelloWorldDao}.
 *
 * @author jeetemplates
 */
public class HelloWorldDaoTest extends BaseDaoTest {

    /**
     * {@link HelloWorldDao}.
     */
    @Autowired
    private HelloWorldDao helloWorldDao;

    /**
     * @return @throws java.lang.Exception
     * @see org.dbunit.DatabaseTestCase#getDataSet()
     */
    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(new FileInputStream("src/test/resources/dataset/dataset.xml"));
    }

    @Test
    public void testRetrieveAll() {
        List<HelloWorld> results = helloWorldDao.retrieveAll();
        Assert.assertNotNull(results);
        Assert.assertEquals(2, results.size());
    }

}
