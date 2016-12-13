package com.xm.config;

import java.util.List;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.eframework.config.plugin.ConfigPlugin;
import com.eframework.core.model.EModel;
import com.eframework.core.thread.ThreadPlugin;
import com.eframework.ext.redis.RedisKit;
import com.eframework.ext.shiro.ShiroKit;
import com.eframework.ext.shiro.ShiroPlugin;
import com.eframework.model._ModuleMappingKit;
import com.eframework.model._SysMappingKit;
import com.eframework.module.sys.log.SysLogService;
import com.jfinal.config.Plugins;
import com.jfinal.ext.plugin.sqlinxml.SqlInXmlPlugin;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.dialect.AnsiSqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.RedisPlugin;
public class SysPlugins extends ConfigPlugin {

	@Override
	public void config(Plugins me) {
		/**主数据源**/
		DruidPlugin mainPlugin=createDruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
		me.add(mainPlugin);
		ActiveRecordPlugin mainArp=new ActiveRecordPlugin(mainPlugin);
		mainArp.setDialect(new AnsiSqlDialect());
		mainArp.setShowSql(true);
		mainArp.setCache(new RedisKit());
		me.add(mainArp);
		_SysMappingKit.mapping(mainArp);
		_ModuleMappingKit.mapping(mainArp);
        /**主数据源**/
      
		/**log数据源**/
		/**sql.xml解析**/
        me.add(new SqlInXmlPlugin());
        /**EhCache缓存**/
       // me.add(new EhCachePlugin());
        /**redis**/
        me.add(new RedisPlugin("db0", PropKit.get("redis.host"), PropKit.getInt("redis.port")));
        /**登录地址**/
        ShiroKit.setLoginUrl("/login.jsp");
        /**管理端首页**/
        ShiroKit.setSuccessUrl("/admin");
        /**无访问权限事访问页面**/
        ShiroKit.setUnauthorizedUrl("/403.jsp");
        /**权限管理**/
        ShiroPlugin shiroPlugin = new ShiroPlugin(SysRoutes.routes);
        me.add(shiroPlugin);
        me.add(new ThreadPlugin() {
			@Override
			public boolean callback(List<? extends EModel<?>> list) {
				boolean is=true;
				try {
					SysLogService.service.save(list, 10);
				} catch (Exception e) {
					e.printStackTrace();
					is=false;
				}
				return is;
			}
		});
       
	}
	
	/**
     * 
    * @Title: createDruidPlugin 
    * @Description: DruidPlugin数据源
    * @return DruidPlugin
     */
    public static DruidPlugin createDruidPlugin(String jdbcUrl,String user,String password) {
    	DruidPlugin druidPlugin=null;
    	 druidPlugin =
                 new DruidPlugin(jdbcUrl, user, password);
         druidPlugin.addFilter(new StatFilter());
         WallFilter wall = new WallFilter();
         wall.setDbType("mysql");
         druidPlugin.addFilter(wall);
        return druidPlugin;
    }

}
