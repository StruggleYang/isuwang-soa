package com.isuwang.soa.transaction.db.action

import java.sql.Timestamp
import java.util.Date

import com.isuwang.scala.dbc.Action
import com.isuwang.scala.dbc.Assert._
import com.isuwang.soa.core.TransactionContext
import com.isuwang.soa.transaction.TransactionSQL
import com.isuwang.soa.transaction.api.domain.{TGlobalTransaction, TGlobalTransactionProcess}
import com.isuwang.soa.transaction.db.domain.{GlobalTransaction, GlobalTransactionProces}
import com.isuwang.soa.transaction.utils.{DateUtils, ErrorCode}
import org.slf4j.{LoggerFactory, Logger}

/**
  * Created by tangliu on 2016/4/12.
  */
class GlobalTransactionCreateAction(dto: TGlobalTransaction) extends Action[TGlobalTransaction] {

  val LOGGER: Logger = LoggerFactory.getLogger(classOf[GlobalTransactionCreateAction])

  /**
    * 输入检查：查询、新增、更新、删除等输入条件
    */
  override def inputCheck: Unit = {
    assert(dto.getStatus != null, ErrorCode.INPUTERROR.getCode, "状态不能为空")
    assert(dto.getCurrSequence != null, ErrorCode.INPUTERROR.getCode, "当前过程序列号不能为空")
  }

  /**
    * 动作
    */
  override def action: TGlobalTransaction = {

    val now: Date = DateUtils.resetMillisecond(new Date)

    val header = TransactionContext.Factory.getCurrentInstance().getHeader

    val transaction: GlobalTransaction = new GlobalTransaction {

      this.status = dto.getStatus.getValue
      this.currSequence = dto.getCurrSequence

      this.createdAt = new Timestamp(now.getTime)
      this.updatedAt = new Timestamp(now.getTime)
      this.createdBy = if (header.getOperatorId.isPresent) header.getOperatorId.get else 0
      this.updatedBy = if (header.getOperatorId.isPresent) header.getOperatorId.get else 0

    }

    dto.setId(TransactionSQL.insertTransaction(transaction))

    LOGGER.info("创建全局事务({}),状态为({}),当前过程序列号为({})", dto.getId.toString, dto.getStatus.getValue.toString, dto.getCurrSequence.toString);

    dto
  }

  /**
    * 后置条件检查
    */
  override def postCheck: Unit = {}

  /**
    * 前置条件检查：动作、状态等业务逻辑
    */
  override def preCheck: Unit = {}
}
