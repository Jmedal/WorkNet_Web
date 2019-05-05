package com.example.worknet.common.persistence.affair.message.serviceImpl;

import com.example.worknet.common.persistence.template.modal.Message;
import com.example.worknet.common.persistence.template.dao.MessageMapper;
import com.example.worknet.common.persistence.affair.message.service.MessageService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息记录表 服务实现类
 * </p>
 *
 * @author YunJieJiang123
 * @since 2019-04-27
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
