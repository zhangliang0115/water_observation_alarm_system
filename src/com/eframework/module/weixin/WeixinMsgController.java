package com.eframework.module.weixin;

import java.util.List;

import lombok.extern.log4j.Log4j;

import com.eframework.kit.StrKit;
import com.eframework.module.buss.account.info.BussAccountInfoService;
import com.eframework.module.buss.wx.event.msg.BussWxEventMsgService;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.MsgController;
import com.jfinal.weixin.sdk.msg.in.InImageMsg;
import com.jfinal.weixin.sdk.msg.in.InLinkMsg;
import com.jfinal.weixin.sdk.msg.in.InLocationMsg;
import com.jfinal.weixin.sdk.msg.in.InNotDefinedMsg;
import com.jfinal.weixin.sdk.msg.in.InShortVideoMsg;
import com.jfinal.weixin.sdk.msg.in.InTextMsg;
import com.jfinal.weixin.sdk.msg.in.InVideoMsg;
import com.jfinal.weixin.sdk.msg.in.InVoiceMsg;
import com.jfinal.weixin.sdk.msg.in.event.InCustomEvent;
import com.jfinal.weixin.sdk.msg.in.event.InFollowEvent;
import com.jfinal.weixin.sdk.msg.in.event.InLocationEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMassEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMerChantOrderEvent;
import com.jfinal.weixin.sdk.msg.in.event.InNotDefinedEvent;
import com.jfinal.weixin.sdk.msg.in.event.InPoiCheckNotifyEvent;
import com.jfinal.weixin.sdk.msg.in.event.InQrCodeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InShakearoundUserShakeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InSubmitMemberCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InTemplateMsgEvent;
import com.jfinal.weixin.sdk.msg.in.event.InUpdateMemberCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InUserPayFromCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InUserViewCardEvent;
import com.jfinal.weixin.sdk.msg.in.event.InVerifyFailEvent;
import com.jfinal.weixin.sdk.msg.in.event.InVerifySuccessEvent;
import com.jfinal.weixin.sdk.msg.in.event.InWifiEvent;
import com.jfinal.weixin.sdk.msg.in.speech_recognition.InSpeechRecognitionResults;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;

public class WeixinMsgController extends MsgController {

	@Override
	public ApiConfig getApiConfig() {
		
		return WeiApiConfig.init();
	}

	@Override
	protected void processInTextMsg(InTextMsg inTextMsg) {
	}

	@Override
	protected void processInImageMsg(InImageMsg inImageMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInVoiceMsg(InVoiceMsg inVoiceMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInVideoMsg(InVideoMsg inVideoMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInShortVideoMsg(InShortVideoMsg inShortVideoMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInLocationMsg(InLocationMsg inLocationMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInLinkMsg(InLinkMsg inLinkMsg) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInCustomEvent(InCustomEvent inCustomEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInFollowEvent(InFollowEvent inFollowEvent) {
		if (InFollowEvent.EVENT_INFOLLOW_SUBSCRIBE.equals(inFollowEvent.getEvent())){
			String openid=inFollowEvent.getFromUserName();
			//添加用户tag
			List<Integer> rows=BussAccountInfoService.query("SELECT id from buss_account_info info where status=1 and exists (	select 1 from buss_account_thirdparty tp where tp.id=info.account_thirdparty_id and tp.thirdparty_id=1 and tp.thirdparty_no=?)",openid);
			if(rows!=null &&rows.size()>0){
				BussAccountInfoService.service.batchPass(rows.toArray(new Integer[rows.size()]));
			}
		}

	}

	@Override
	protected void processInQrCodeEvent(InQrCodeEvent inQrCodeEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInLocationEvent(InLocationEvent inLocationEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInMassEvent(InMassEvent inMassEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInMenuEvent(InMenuEvent inMenuEvent) {
		String enent_key=inMenuEvent.getEventKey();
		if(enent_key.startsWith("http")){
		//	renderOutTextMsg("success");
		}else{
			String msg=BussWxEventMsgService.service.msg(inMenuEvent);
			if(!StrKit.isBlank(msg)){
				renderOutTextMsg(msg);
			}else{
				renderOutTextMsg("暂无结果，请稍后再试");
			}
		}

	}

	@Override
	protected void processInSpeechRecognitionResults(
			InSpeechRecognitionResults inSpeechRecognitionResults) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInTemplateMsgEvent(
			InTemplateMsgEvent inTemplateMsgEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInShakearoundUserShakeEvent(
			InShakearoundUserShakeEvent inShakearoundUserShakeEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInVerifySuccessEvent(
			InVerifySuccessEvent inVerifySuccessEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInVerifyFailEvent(InVerifyFailEvent inVerifyFailEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInPoiCheckNotifyEvent(
			InPoiCheckNotifyEvent inPoiCheckNotifyEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInWifiEvent(InWifiEvent inWifiEvent) {
		renderOutTextMsg(new OutTextMsg().toXml());

	}

	@Override
	protected void processInUserViewCardEvent(
			InUserViewCardEvent inUserViewCardEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInSubmitMemberCardEvent(
			InSubmitMemberCardEvent inSubmitMemberCardEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInUpdateMemberCardEvent(
			InUpdateMemberCardEvent inUpdateMemberCardEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInUserPayFromCardEvent(
			InUserPayFromCardEvent inUserPayFromCardEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processInMerChantOrderEvent(
			InMerChantOrderEvent inMerChantOrderEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processIsNotDefinedEvent(InNotDefinedEvent inNotDefinedEvent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void processIsNotDefinedMsg(InNotDefinedMsg inNotDefinedMsg) {
		// TODO Auto-generated method stub

	}

}
