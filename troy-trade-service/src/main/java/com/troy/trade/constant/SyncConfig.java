package com.troy.trade.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 数据同步相关参数
 * @author yanping
 * @datetime 2017年8月3日上午9:15:19
 */
@Component
@ConfigurationProperties(prefix = "sync")
public class SyncConfig {

	/**
	 * 交易对相关 同步标识
	 */
	private boolean symbol;

	private boolean allTicker;

	private boolean blockchainLargetransfer;

	private boolean abnormalChanges;

	private boolean contractInfo;

	public boolean isSymbol() {
		return symbol;
	}

	public void setSymbol(boolean symbol) {
		this.symbol = symbol;
	}

	public boolean isAllTicker() {
		return allTicker;
	}

	public void setAllTicker(boolean allTicker) {
		this.allTicker = allTicker;
	}

	public boolean isBlockchainLargetransfer() {
		return blockchainLargetransfer;
	}

	public void setBlockchainLargetransfer(boolean blockchainLargetransfer) {
		this.blockchainLargetransfer = blockchainLargetransfer;
	}

	public boolean isAbnormalChanges() {
		return abnormalChanges;
	}

	public void setAbnormalChanges(boolean abnormalChanges) {
		this.abnormalChanges = abnormalChanges;
	}

	public boolean isContractInfo() {
		return contractInfo;
	}

	public void setContractInfo(boolean contractInfo) {
		this.contractInfo = contractInfo;
	}
}
